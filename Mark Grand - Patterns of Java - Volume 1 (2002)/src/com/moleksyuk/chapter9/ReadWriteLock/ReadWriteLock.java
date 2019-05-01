/**
 * 
 */
package com.moleksyuk.chapter9.ReadWriteLock;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class ReadWriteLock {

	private int waitingForReadLock = 0;
	private int outstandingReadLocks = 0;
	private ArrayList<Thread> waitingForWriteLock = new ArrayList<Thread>();
	private Thread writeLockedThread;

	public synchronized void readLock() throws InterruptedException {
		if (writeLockedThread != null) {
			waitingForReadLock++;
			while (writeLockedThread != null) {
				wait();
			}
			waitingForReadLock--;
		}
		outstandingReadLocks++;
	}

	public void writeLock() throws InterruptedException {
		Thread thisThread;
		synchronized (this) {
			if (writeLockedThread == null && outstandingReadLocks == 0) {
				writeLockedThread = Thread.currentThread();
				return;
			}
			thisThread = Thread.currentThread();
			waitingForWriteLock.add(thisThread);
		}

		synchronized (thisThread) {
			while (thisThread != writeLockedThread) {
				thisThread.wait();
			}
			synchronized (this) {
				waitingForWriteLock.remove(thisThread);
			}
		}
	}

	public synchronized void done() {
		if (outstandingReadLocks > 0) {
			outstandingReadLocks--;
			if (outstandingReadLocks == 0 && waitingForWriteLock.size() > 0) {
				writeLockedThread = waitingForWriteLock.get(0);
				writeLockedThread.notifyAll();
			}
		} else if (Thread.currentThread() == writeLockedThread) {
			if (outstandingReadLocks == 0 && waitingForWriteLock.size() > 0) {
				writeLockedThread = waitingForWriteLock.get(0);
				writeLockedThread.notifyAll();
			}
		} else {
			writeLockedThread = null;
			if (waitingForReadLock > 0) {
				notifyAll();
			} else {
				String msg = "Thread doesn't have lock";
				throw new IllegalStateException(msg);
			}
		}
	}
}
