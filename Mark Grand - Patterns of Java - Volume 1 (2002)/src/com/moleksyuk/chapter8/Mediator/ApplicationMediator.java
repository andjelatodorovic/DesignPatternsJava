/**
 * 
 */
package com.moleksyuk.chapter8.Mediator;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 16, 2011
 * 
 * @author moleksyuk
 */
public class ApplicationMediator implements IMediator {

	private ArrayList<Colleague> colleagues;

	public ApplicationMediator() {
		colleagues = new ArrayList<Colleague>();
	}

	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter8.Mediator.IMediator#send(java.lang.String,
	 * com.moleksyuk.chapter8.Mediator.Colleague)
	 */
	@Override
	public void send(String message, Colleague originator) {
		for (Colleague col : colleagues) {
			if (col != originator) {
				col.receive(message);
			}
		}
	}

}
