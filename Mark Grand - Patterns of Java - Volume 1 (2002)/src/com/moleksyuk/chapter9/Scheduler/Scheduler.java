/**
 * 
 */
package com.moleksyuk.chapter9.Scheduler;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class Scheduler {
	private Thread runningThread;
	private ArrayList<ScheduleOrdering> waitingRequests = new ArrayList<ScheduleOrdering>();
	private ArrayList<Thread> waitingThreads = new ArrayList<Thread>();

	public void enter(ScheduleOrdering s) throws InterruptedException {
		Thread thisThread = Thread.currentThread();

		synchronized (this) {
			if (runningThread == null) {
				runningThread = thisThread;
				return;
			}
			waitingThreads.add(thisThread);
			waitingRequests.add(s);
		}

		synchronized (thisThread) {
			while (thisThread != runningThread) {
				thisThread.wait();
			}
		}

		synchronized (this) {
			int i = waitingThreads.indexOf(thisThread);
			waitingThreads.remove(i);
			waitingRequests.remove(i);
		}
	}

	public synchronized void done() {
		if (runningThread != Thread.currentThread()) {
			throw new IllegalStateException("Wrong Thread");
		}
		int waitCount = waitingThreads.size();
		if (waitCount <= 0) {
			runningThread = null;
		} else if (waitCount == 1) {
			runningThread = (Thread) waitingThreads.get(0);
			waitingThreads.remove(0);
		} else {
			int next = waitCount - 1;
			ScheduleOrdering nextRequest = waitingRequests.get(next);
			for (int i = waitCount - 2; i >= 0; i--) {
				ScheduleOrdering r = waitingRequests.get(i);
				if (r.scheduleBefore(nextRequest)) {
					next = i;
					nextRequest = waitingRequests.get(next);
				}
			}
			runningThread = waitingThreads.get(next);
			synchronized (runningThread) {
				runningThread.notifyAll();
			}
		}
	}
}
