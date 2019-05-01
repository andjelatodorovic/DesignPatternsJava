/**
 * 
 */
package com.moleksyuk.chapter8.Strategy;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 12, 2011
 * 
 * @author moleksyuk
 */
public class ConcreteStrategyB implements IStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter8.Strategy.IStrategy#operation()
	 */
	@Override
	public void operation() {
		System.out.println("Strategy B!");
	}

}
