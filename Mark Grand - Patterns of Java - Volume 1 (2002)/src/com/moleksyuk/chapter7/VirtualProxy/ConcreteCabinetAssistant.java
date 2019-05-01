/**
 * 
 */
package com.moleksyuk.chapter7.VirtualProxy;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 10, 2011
 * 
 * @author moleksyuk
 */
public class ConcreteCabinetAssistant implements ICabinetAssistant {
	String incomeParams;

	public ConcreteCabinetAssistant(String s) {
		this.incomeParams = s;
	}

	@Override
	public void operation1() {
		System.out.println("Operation1 with " + incomeParams);
	}

	@Override
	public void operation2() {
		System.out.println("Operation2 with " + incomeParams);
	}

}
