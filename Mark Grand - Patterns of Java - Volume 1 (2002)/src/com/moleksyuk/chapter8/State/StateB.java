package com.moleksyuk.chapter8.State;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class StateB implements IState {

	@Override
	public void writeName(StateContext context, String name) {
		System.out.println(name.toUpperCase());
		context.setState(new StateA());
	}

}
