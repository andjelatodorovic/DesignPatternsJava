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
public interface ScheduleOrdering {
	public boolean scheduleBefore(ScheduleOrdering s);
}
