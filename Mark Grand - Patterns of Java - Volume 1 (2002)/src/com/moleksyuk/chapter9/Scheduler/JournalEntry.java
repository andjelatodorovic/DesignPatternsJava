/**
 * 
 */
package com.moleksyuk.chapter9.Scheduler;

import java.util.Date;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class JournalEntry implements ScheduleOrdering {

	private Date time = new Date();

	public Date getTime() {
		return time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter9.Scheduler.ScheduleOrdering#scheduleBefore(com.
	 * moleksyuk.chapter9.Scheduler.ScheduleOrdering)
	 */
	@Override
	public boolean scheduleBefore(ScheduleOrdering s) {
		if (s instanceof JournalEntry) {
			return getTime().before(((JournalEntry) s).getTime());
		}
		return false;
	}
}
