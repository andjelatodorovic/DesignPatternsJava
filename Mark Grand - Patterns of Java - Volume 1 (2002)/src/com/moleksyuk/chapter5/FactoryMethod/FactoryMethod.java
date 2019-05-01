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
public class FactoryMethod {

	private FactoryMethod() {

	}

	public static ICellPhone createCellPhone(CellPhonetTypes type) {
		if (CellPhonetTypes.HTC.equals(type)) {
			return new HTC();
		} else if (CellPhonetTypes.SAMSUNG.equals(type)) {
			return new Samsung();
		} else if (CellPhonetTypes.IPHONE.equals(type)) {
			return new IPhone();
		} else {
			throw new IllegalArgumentException(
					"Not supported type of cell phone:" + type);
		}
	}
}
