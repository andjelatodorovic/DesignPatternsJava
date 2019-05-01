/**
 * 
 */
package com.moleksyuk.chapter6.Filter;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public class FileInStream implements IInStream {

	private RandomAccessFile file;

	public FileInStream(String fileName) throws IOException {
		file = new RandomAccessFile(fileName, "r");
	}

	@Override
	public int read(byte[] array) throws IOException {
		return file.read(array);
	}

}
