/**
 * 
 */
package com.moleksyuk.chapter7.VirtualProxy;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 10, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICabinetAssistant assistant = new CabinetAssistantProxy("Hi!");
		assistant.operation1();
		assistant.operation2();
	}

}
