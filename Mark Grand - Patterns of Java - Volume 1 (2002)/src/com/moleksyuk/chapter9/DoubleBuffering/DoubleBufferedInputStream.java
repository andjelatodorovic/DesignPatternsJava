/**
 * 
 */
package com.moleksyuk.chapter9.DoubleBuffering;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 23, 2011
 * 
 * @author moleksyuk
 */
public class DoubleBufferedInputStream extends FilterInputStream {

	private static final int DEFAULT_BUFFER_COUNT = 2;
	private static final int DEFAULT_BUFFER_SIZE = 4096;
	private byte[][] buffers;
	private int activeBuffer = 0;
	private int[] counts;
	private int pos;
	private Throwable exception;
	private boolean exhausted;
	private boolean eof;
	private BufferFiller myBufferFiller;
	private Object lockObject = new Object();

	public DoubleBufferedInputStream(InputStream in) {
		this(in, DEFAULT_BUFFER_SIZE);
	}

	public DoubleBufferedInputStream(InputStream in, int size) {
		this(in, size, DEFAULT_BUFFER_COUNT);
	}

	public DoubleBufferedInputStream(InputStream in, int size, int bufferCount) {
		super(in);
		if (size < 1) {
			String msg = "Buffer size < 1";
			throw new IllegalArgumentException(msg);
		}
		if (bufferCount < 2) {
			bufferCount = DEFAULT_BUFFER_COUNT;
		}
		buffers = new byte[bufferCount][size];
		counts = new int[bufferCount];
		myBufferFiller = new BufferFiller();
	}

	@Override
	public synchronized int read() throws IOException {
		checkClosed();
		if (eof) {
			return -1;
		}
		if (pos >= counts[activeBuffer]) {
			eof = !advanceBuffer();
		}
		if (eof) {
			return -1;
		}

		int c = buffers[activeBuffer][pos++] & 0xff;
		if (pos >= counts[activeBuffer]) {
			eof = !advanceBuffer();
		}
		return c;
	}

	@Override
	public synchronized int read(byte b[], int off, int len) throws IOException {
		checkClosed();
		if ((off | len | (off + len) | (b.length - (off + len))) < 0) {
			throw new IndexOutOfBoundsException();
		} else if (eof) {
			return -1;
		} else if (len == 0) {
			return 0;
		}

		int howMany = 0;
		do {
			if (len <= counts[activeBuffer] - pos) {
				System.arraycopy(buffers[activeBuffer], pos, b, off, len);
				howMany += len;
				pos += len;
				len = 0;
			} else {
				int remaining = counts[activeBuffer] - pos;
				System.arraycopy(buffers[activeBuffer], pos, b, off, remaining);
				howMany += remaining;
				pos += remaining;
				len -= remaining;
				off += remaining;
			}
			if (pos >= counts[activeBuffer]) {
				eof = !advanceBuffer();
			}
		} while (!eof && len > 0);
		return howMany;
	}

	private boolean advanceBuffer() throws IOException {
		int nextActiveBuffer = (activeBuffer + 1) % counts.length;
		if (counts[nextActiveBuffer] == 0) {
			if (exhausted) {
				rethrowException();
				return false;
			}
			myBufferFiller.fillReserve();

			synchronized (lockObject) {
				while (counts[nextActiveBuffer] == 0 && !exhausted) {
					try {
						lockObject.wait();
					} catch (InterruptedException e) {
						IOException ioe = new InterruptedIOException();
						ioe.initCause(e);
						throw ioe;
					}
				}
			}
			if (counts[nextActiveBuffer] == 0 && exhausted) {
				rethrowException();
				return false;
			}
		}
		counts[activeBuffer] = 0;
		activeBuffer = nextActiveBuffer;
		pos = 0;
		myBufferFiller.fillReserve();
		return true;
	}

	private void rethrowException() throws IOException {
		if (exception != null) {
			Throwable e = exception;
			exception = null;
			close();
			if (e instanceof IOException) {
				throw (IOException) e;
			} else if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else if (e instanceof Error) {
				throw (Error) e;
			} else {
				IOException ioe = new IOException("An error occurred");
				ioe.initCause(e);
				throw ioe;
			}
		}
	}

	@Override
	public synchronized long skip(long n) throws IOException {
		checkClosed();
		if (n <= 0) {
			return 0;
		}
		long skipped = 0;
		int thisBuffer = activeBuffer;
		do {
			int remaining = counts[thisBuffer] - pos;
			if (remaining >= n) {
				pos += n;
				skipped += n;
				break;
			}
			pos = 0;
			n -= remaining;
			skipped += remaining;
			thisBuffer = (thisBuffer + 1) % counts.length;
		} while (thisBuffer != activeBuffer);

		activeBuffer = thisBuffer;
		myBufferFiller.fillReserve();
		return skipped;
	}

	@Override
	public synchronized int available() throws IOException {
		checkClosed();
		int count = 0;
		for (int i = 0; i < counts.length; i++) {
			count += counts[i];
		}
		return count;
	}

	@Override
	public void close() throws IOException {
		if (buffers == null) {
			return;
		}
		myBufferFiller.close();
		buffers = null;
		counts = null;
	}

	private void checkClosed() throws IOException {
		if (buffers == null) {
			throw new IOException("Stream is closed.");
		}
	}

	private class BufferFiller implements Runnable {

		private boolean outstandingFillRequest;
		private Thread myThread;

		BufferFiller() {
			myThread = new Thread(this, "Buffer Filler");
			myThread.start();
		}

		private int fillOneBuffer(int ndx) throws IOException {
			counts[ndx] = in.read(buffers[ndx]);
			return counts[ndx];
		}

		private void fill() throws IOException {
			for (int i = (activeBuffer + 1) % counts.length; i != activeBuffer
					&& !myThread.isInterrupted(); i = (i + 1) % counts.length) {
				if (counts[i] == 0) {
					int thisCount = fillOneBuffer(i);
					if (thisCount == -1) {
						exhausted = true;
						Thread.currentThread().interrupt();
					}
				} else {
					synchronized (lockObject) {
						lockObject.notifyAll();
					}
				}
			}
		}

		@Override
		public synchronized void run() {
			try {
				while (!myThread.isInterrupted() && !exhausted) {
					synchronized (this) {
						while (!outstandingFillRequest) {
							wait();
						}
					}
					fill();
					outstandingFillRequest = false;
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			} catch (ThreadDeath e) {
				throw e;
			} catch (Throwable e) {
				exception = e;
			} finally {
				exhausted = true;
				synchronized (lockObject) {
					lockObject.notifyAll();
				}
				try {
					in.close();
				} catch (IOException e) {
					if (exception == null) {
						exception = e;
					}
				}
				in = null;
			}
		}

		synchronized void fillReserve() {
			outstandingFillRequest = true;
			notifyAll();
		}

		void close() {
			myThread.interrupt();
		}

	}
}
