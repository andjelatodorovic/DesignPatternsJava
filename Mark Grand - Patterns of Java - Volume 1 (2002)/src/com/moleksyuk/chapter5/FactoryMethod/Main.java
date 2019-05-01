/**
 * 
 */
package com.moleksyuk.chapter5.FactoryMethod;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 26, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {

		for (CellPhonetTypes type : CellPhonetTypes.values()) {
			System.out.println(FactoryMethod.createCellPhone(type).getClass());
		}

	}

}
