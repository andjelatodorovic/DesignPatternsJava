package com.moleksyuk.chapter8.Command;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class CommandManager {

	private ICommand command;

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}
