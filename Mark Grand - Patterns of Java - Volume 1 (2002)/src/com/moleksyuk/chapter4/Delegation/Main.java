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
public class Main {

	public static void main(String[] args) {
		Delegator delegator = new Delegator();

		IDelegation delegate1 = new ConcreteDelegate1();
		delegator.setDelegate(delegate1);
		delegator.doSomething();

		IDelegation delegate2 = new ConcreteDelegate2();
		delegator.setDelegate(delegate2);
		delegator.doSomething();
	}
}
