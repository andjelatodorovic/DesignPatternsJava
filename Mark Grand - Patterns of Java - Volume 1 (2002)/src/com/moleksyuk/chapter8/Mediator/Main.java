/**
 * 
 */
package com.moleksyuk.chapter8.Mediator;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 16, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		ApplicationMediator mediator = new ApplicationMediator();
		MobileColleague mobile = new MobileColleague(mediator);
		DesktopColleague desktop = new DesktopColleague(mediator);
		mediator.addColleague(mobile);
		mediator.addColleague(desktop);
		mobile.send("Hello from mobile!");
		desktop.send("Hello from desktop!");
	}
}
