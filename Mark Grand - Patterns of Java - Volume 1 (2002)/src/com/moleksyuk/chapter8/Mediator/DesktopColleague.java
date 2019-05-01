package com.moleksyuk.chapter8.Mediator;

public class DesktopColleague extends Colleague {

	public DesktopColleague(IMediator mediator) {
		super(mediator);
	}

	@Override
	public void receive(String message) {
		System.out.println("Desktop Received: " + message);
	}

}
