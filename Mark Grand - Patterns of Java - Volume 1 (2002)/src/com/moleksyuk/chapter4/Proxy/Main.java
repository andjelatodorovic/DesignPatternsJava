/**
 * 
 */
package com.moleksyuk.chapter4.Proxy;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 26, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImageProxy proxy = new ImageProxy("some file name");
		proxy.draw();
	}

}
