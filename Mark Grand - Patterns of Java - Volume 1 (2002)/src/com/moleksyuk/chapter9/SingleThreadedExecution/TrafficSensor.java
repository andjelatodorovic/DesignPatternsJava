/**
 * 
 */
package com.moleksyuk.chapter9.SingleThreadedExecution;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 18, 2011
 * 
 * @author moleksyuk
 */
public class TrafficSensor implements Runnable {

	private TrafficObserver observer;

	public TrafficSensor(TrafficObserver observer) {
		this.observer = observer;
		new Thread(this).start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		monitorSensor();
	}

	private native void monitorSensor();

	private void detect() {
		observer.vehiclePassed();
	}

	public interface TrafficObserver {
		public void vehiclePassed();
	}
}
