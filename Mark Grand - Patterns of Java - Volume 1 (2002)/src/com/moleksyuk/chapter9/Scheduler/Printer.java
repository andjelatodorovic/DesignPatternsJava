/**
 * 
 */
package com.moleksyuk.chapter9.Scheduler;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class Printer {

	private Scheduler scheduler = new Scheduler();

	public void print(JournalEntry j) {
		try {
			scheduler.enter(j);
			try {
				// ...
			} finally {
				scheduler.done();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
