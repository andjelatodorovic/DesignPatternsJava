/**
 * 
 */
package com.moleksyuk.chapter4.Interface;

import java.util.HashMap;
import java.util.Map;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 20, 2011
 * 
 * @author moleksyuk
 */
public class AddressService {
	Map<String, IAddress> addresses;

	public AddressService() {
		addresses = new HashMap<String, IAddress>();
		addresses.put("Apple", new Apple());
		addresses.put("IBM", new IBM());
		addresses.put("Microsoft", new Microsoft());
	}

	public String getAddress(String company) {
		return ((IAddress) addresses.get(company)).getAddress();
	}
}
