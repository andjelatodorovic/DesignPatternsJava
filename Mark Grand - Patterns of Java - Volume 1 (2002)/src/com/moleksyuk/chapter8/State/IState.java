package com.moleksyuk.chapter8.State;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public interface IState {
	public void writeName(StateContext context, String name);
}
