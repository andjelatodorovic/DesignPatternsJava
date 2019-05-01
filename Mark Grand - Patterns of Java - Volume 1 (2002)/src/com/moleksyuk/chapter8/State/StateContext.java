package com.moleksyuk.chapter8.State;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class StateContext {

	IState state;

	public StateContext() {
		setState(new StateA());
	}

	public void setState(IState state) {
		this.state = state;
	}

	public void writeName(String name) {
		state.writeName(this, name);
	}
}
