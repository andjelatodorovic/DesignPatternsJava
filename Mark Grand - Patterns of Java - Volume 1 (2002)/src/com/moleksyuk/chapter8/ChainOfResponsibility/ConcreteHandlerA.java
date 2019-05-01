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
public class ConcreteHandlerA implements IChainOfResposibility {

	private IChainOfResposibility next;

	@Override
	public void setNextHandler(IChainOfResposibility handler) {
		this.next = handler;
	}

	@Override
	public void handleRequest(String message) {
		if (message == null || message.endsWith("@gmail.com")) {
			if (next == null)
				throw new RuntimeException(
						"Don't have appropriate handler for message: "
								+ message);
			next.handleRequest(message);
		} else {
			System.out.println("Handling message in " + this.getClass());
		}
	}
}
