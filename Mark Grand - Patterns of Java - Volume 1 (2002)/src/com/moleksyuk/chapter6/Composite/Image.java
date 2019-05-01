/**
 * 
 */
package com.moleksyuk.chapter6.Composite;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public class Image extends AbstractDocumentElement {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter6.Composite.AbstractDocumentElement#getCharLength()
	 */
	@Override
	public int getCharLength() {
		return 1;
	}

}
