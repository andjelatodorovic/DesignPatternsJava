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
public class TranslateInStream extends FilterInStream {

	private byte[] translationTable;
	private final static int TRANS_TBL_LENGTH = 256;

	public TranslateInStream(IInStream inStream, byte[] table) {
		super(inStream);

		translationTable = new byte[TRANS_TBL_LENGTH];
		System.arraycopy(table, 0, translationTable, 0,
				Math.min(TRANS_TBL_LENGTH, table.length));
		for (int i = table.length; i < TRANS_TBL_LENGTH; i++) {
			translationTable[i] = (byte) i;
		}
	}

	@Override
	public int read(byte[] array) throws IOException {
		int count = super.read(array);
		for (int i = 0; i < count; i++) {
			array[i] = translationTable[array[i]];
		}
		return count;
	}

}
