/**
 * 
 */
package com.moleksyuk.chapter6.Filter;

import java.io.IOException;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public class ByteCountInStream extends FilterInStream {

	private long byteCount = 0;

	public ByteCountInStream(IInStream inStream) {
		super(inStream);
	}

	@Override
	public int read(byte[] array) throws IOException {
		int count;
		count = super.read(array);
		if (count > 0) {
			byteCount += count;
		}
		return count;
	}

	public long getByteCount() {
		return byteCount;
	}
}
