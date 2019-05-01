/**
 * 
 */
package com.moleksyuk.chapter7.Decorator;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 11, 2011
 * 
 * @author moleksyuk
 */
public class ConcreteDecorator extends AbstractDecorator {

	private String camera;
	private IAnotherComponent monitor;

	public ConcreteDecorator(IComponent wrappee, IAnotherComponent monitor,
			String camera) {
		super(wrappee);
		this.monitor = monitor;
		this.camera = camera;
	}

	public void requestOper(String key) {
		monitor.viewNow(camera);
		super.requestOpent(key);
	}
}
