/**
 * 
 */
package com.moleksyuk.chapter4.MarkerInterface;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 2, 2011
 * 
 * @author moleksyuk
 */
public class Worker {

	public static void doSomething(Object object) {
		if (object instanceof MarkerInterface) {
			System.out.println("Doing something with " + object.getClass());
		} else {
			throw new UnsupportedOperationException(
					"Operation is not supported for " + object.getClass());
		}
	}
}
