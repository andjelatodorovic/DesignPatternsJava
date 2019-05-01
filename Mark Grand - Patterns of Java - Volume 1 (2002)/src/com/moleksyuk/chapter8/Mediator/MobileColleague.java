package com.moleksyuk.chapter8.Mediator;

public class MobileColleague extends Colleague {

	public MobileColleague(IMediator mediator) {
		super(mediator);
	}

	@Override
	public void receive(String message) {
		System.out.println("Mobile Received: " + message);
	}
}
