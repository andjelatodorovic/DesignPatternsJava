/**
 * 
 */
package com.moleksyuk.chapter4.Interface;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 20, 2011
 * 
 * @author moleksyuk
 */
public class Apple implements IAddress {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.Interface.IAddress#getAddress()
	 */
	@Override
	public String getAddress() {
		return "1 Infinite Loop Cupertino, CA 95014 408.996.1010";
	}

}
