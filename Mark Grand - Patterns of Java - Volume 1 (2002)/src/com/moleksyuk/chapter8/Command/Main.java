package com.moleksyuk.chapter8.Command;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		CommandManager cm = new CommandManager();
		Light light = new Light();

		cm.setCommand(new LightOn(light));
		cm.pressButton();
		System.out.println(light.isIndicator());

		cm.setCommand(new LightOff(light));
		cm.pressButton();
		System.out.println(light.isIndicator());

	}
}
