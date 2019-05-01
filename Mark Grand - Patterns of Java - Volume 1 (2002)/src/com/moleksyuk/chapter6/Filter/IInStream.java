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
public interface IInStream {
	public int read(byte[] array) throws IOException;
}
