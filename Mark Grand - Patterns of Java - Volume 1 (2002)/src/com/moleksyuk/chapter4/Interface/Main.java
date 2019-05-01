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
public class Main {

	public static void main(String[] args) {
		AddressService ads = new AddressService();
		System.out
				.println("Miki:\tHi, I want to go to Apple. Do you know the address?");
		System.out.println("Anna:\tHi, Yes of course. It's - "
				+ ads.getAddress("Apple"));
		System.out.println("Miki:\tWhat about IBM?");
		System.out.println("Anna:\tHere is " + ads.getAddress("IBM"));
		System.out.println("Miki:\tAnd one more, Microsoft?");
		System.out.println("Anna:\tNo problem, take it -  "
				+ ads.getAddress("Microsoft"));
	}

}
