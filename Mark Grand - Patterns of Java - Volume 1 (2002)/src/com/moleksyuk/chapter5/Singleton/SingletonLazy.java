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
public class SingletonLazy {
	private static SingletonLazy instance;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}
