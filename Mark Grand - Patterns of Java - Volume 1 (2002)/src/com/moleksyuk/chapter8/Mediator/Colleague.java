/**
 * 
 */
package com.moleksyuk.chapter8.Mediator;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 16, 2011
 * 
 * @author moleksyuk
 */
public abstract class Colleague {
	private IMediator mediator;

	public Colleague(IMediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) {
		mediator.send(message, this);
	}

	public IMediator getMediator() {
		return mediator;
	}

	public abstract void receive(String message);
}
