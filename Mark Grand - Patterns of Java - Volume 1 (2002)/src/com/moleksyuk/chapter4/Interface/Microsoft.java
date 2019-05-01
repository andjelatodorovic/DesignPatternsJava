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
public class Microsoft implements IAddress {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.Interface.IAddress#getAddress()
	 */
	@Override
	public String getAddress() {
		return "Microsoft Corporation One Microsoft Way Redmond, WA 98052-6399 USA";
	}

}
