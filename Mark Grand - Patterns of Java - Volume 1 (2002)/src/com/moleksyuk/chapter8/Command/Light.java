package com.moleksyuk.chapter8.Command;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class Light {

	private boolean indicator;

	public void switchOn() {
		indicator = true;
	}

	public void switchOff() {
		indicator = false;
	}

	public boolean isIndicator() {
		return indicator;
	}

}
