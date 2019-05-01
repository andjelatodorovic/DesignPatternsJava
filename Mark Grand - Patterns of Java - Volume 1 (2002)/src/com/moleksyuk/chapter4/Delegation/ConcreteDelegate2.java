/**
 * 
 */
package com.moleksyuk.chapter4.Delegation;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 20, 2011
 * 
 * @author moleksyuk
 */
public class ConcreteDelegate2 implements IDelegation {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.delegation.IDelegation#doSomething()
	 */
	@Override
	public void doSomething() {
		System.out.println("ConcreteDelegate2: doSomething in my way.");
	}

}
