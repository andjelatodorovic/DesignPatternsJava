/**
 * 
 */
package com.moleksyuk.chapter9.LockObject;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public abstract class AbstractGameObject {

	private final static Object lockObject = new Object();
	private boolean glowing;

	public final Object getLockObject() {
		return lockObject;
	}

	public boolean isGlowing() {
		return glowing;
	}

	public void setGlowing(boolean value) {
		glowing = value;
	}
}
