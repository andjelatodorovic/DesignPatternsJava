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
public class ConcreteHandlerB implements IChainOfResposibility {

	private IChainOfResposibility next;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter8.ChainOfResponsibility.IChainOfResposibility#
	 * setNextHandler
	 * (com.moleksyuk.chapter8.ChainOfResponsibility.IChainOfResposibility)
	 */
	@Override
	public void setNextHandler(IChainOfResposibility handler) {
		this.next = handler;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter8.ChainOfResponsibility.IChainOfResposibility#
	 * handleRequest(java.lang.String)
	 */
	@Override
	public void handleRequest(String message) {
		if (message == null || message.endsWith("@mail.ru")) {
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
