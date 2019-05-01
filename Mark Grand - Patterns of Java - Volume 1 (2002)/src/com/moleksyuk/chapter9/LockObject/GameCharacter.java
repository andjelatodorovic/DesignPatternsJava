/**
 * 
 */
package com.moleksyuk.chapter9.LockObject;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public class GameCharacter extends AbstractGameObject {

	private ArrayList<AbstractWeapons> myWeapons = new ArrayList<AbstractWeapons>();

	public void dropAllWeapons() {
		synchronized (getLockObject()) {
			for (AbstractWeapons w : myWeapons) {
				w.setGlowing(true);
			}
		}
	}
}
