package com.moleksyuk.chapter8.Command;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class LightOn implements ICommand {

	private Light light;

	public LightOn(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.switchOn();
	}

}
