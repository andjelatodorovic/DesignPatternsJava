/**
 * 
 */
package com.moleksyuk.chapter9.Balking;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public class Flusher {

	private boolean flushInProgress = false;

	public void flush() {
		synchronized (this) {
			if (flushInProgress)
				return;
			flushInProgress = true;
		}

		System.out.println("Flush water");
	}

	void flushCompleted() {
		flushInProgress = false;
	}
}
