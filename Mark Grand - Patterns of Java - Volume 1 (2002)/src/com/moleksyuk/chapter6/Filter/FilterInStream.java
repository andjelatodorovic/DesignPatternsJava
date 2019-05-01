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
public abstract class FilterInStream implements IInStream {
	private IInStream inStream;

	public FilterInStream(IInStream inStream) {
		this.inStream = inStream;
	}

	@Override
	public int read(byte[] array) throws IOException {
		return inStream.read(array);
	}

}
