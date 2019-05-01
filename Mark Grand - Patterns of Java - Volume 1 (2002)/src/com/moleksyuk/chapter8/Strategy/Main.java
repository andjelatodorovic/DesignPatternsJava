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
public class Main {

	public static void main(String[] args) {
		Context contextA = new Context(new ConcreteStrategyA());
		Context contextB = new Context(new ConcreteStrategyB());
		contextA.doIt();
		contextB.doIt();
	}
}
