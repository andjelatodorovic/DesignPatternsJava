/**
 * 
 */
package com.moleksyuk.chapter5.Singleton;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 1, 2011
 * 
 * @author moleksyuk
 */
public class Singleton {
	private static Singleton instance = new Singleton();

	private Singleton() {

	}

	public static Singleton getInstance() {
		return instance;
	}
}
