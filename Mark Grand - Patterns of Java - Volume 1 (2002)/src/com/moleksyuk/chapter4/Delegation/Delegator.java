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
public class Delegator {

	IDelegation delegate;

	public void doSomething() {
		delegate.doSomething();
	}

	public void setDelegate(IDelegation delegate) {
		this.delegate = delegate;
	}
}
