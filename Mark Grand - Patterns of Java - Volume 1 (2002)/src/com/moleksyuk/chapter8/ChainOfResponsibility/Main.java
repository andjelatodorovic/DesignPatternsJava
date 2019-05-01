/**
 * 
 */
package com.moleksyuk.chapter8.ChainOfResponsibility;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 12, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		IChainOfResposibility handler1 = new ConcreteHandlerA();
		IChainOfResposibility handler2 = new ConcreteHandlerB();
		handler1.setNextHandler(handler2);

		handler1.handleRequest("bill@gmail.com");
		handler1.handleRequest("stive@mail.ru");
		handler1.handleRequest(null); // Expected RuntimeException
	}
}
