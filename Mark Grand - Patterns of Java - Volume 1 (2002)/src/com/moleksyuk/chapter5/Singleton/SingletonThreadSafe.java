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
public class SingletonThreadSafe {
	private static SingletonThreadSafe instance;

	private SingletonThreadSafe() {

	}

	public static synchronized SingletonThreadSafe getInstance() {
		if (instance == null) {
			instance = new SingletonThreadSafe();
		}
		return instance;
	}
}
