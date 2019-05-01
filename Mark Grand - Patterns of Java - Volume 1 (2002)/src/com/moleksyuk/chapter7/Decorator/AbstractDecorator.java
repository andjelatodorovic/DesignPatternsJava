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
public abstract class AbstractDecorator implements IComponent {

	private IComponent wrappee;

	public AbstractDecorator(IComponent wrappee) {
		this.wrappee = wrappee;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter7.Decorator.IDoorController#requestOpent(java.lang
	 * .String)
	 */
	@Override
	public void requestOpent(String key) {
		wrappee.requestOpent(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter7.Decorator.IDoorController#close()
	 */
	@Override
	public void close() {
		wrappee.close();
	}

}
