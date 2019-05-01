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
public class IBM implements IAddress {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.Interface.IAddress#getAddress()
	 */
	@Override
	public String getAddress() {
		return "IBM Corporation 1 New Orchard Road Armonk, New York 10504-1722 United States";
	}

}
