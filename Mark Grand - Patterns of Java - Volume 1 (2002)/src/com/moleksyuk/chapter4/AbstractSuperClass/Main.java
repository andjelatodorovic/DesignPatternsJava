/**
 * 
 */
package com.moleksyuk.chapter4.AbstractSuperClass;

import java.util.Iterator;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 21, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {

		try {
			Iterator<Object> arrayListIterator = new ArrayListIterator<Object>();
			arrayListIterator.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}

		try {
			Iterator<Object> customIterator = new CustomIterator<Object>();
			customIterator.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
	}

}
