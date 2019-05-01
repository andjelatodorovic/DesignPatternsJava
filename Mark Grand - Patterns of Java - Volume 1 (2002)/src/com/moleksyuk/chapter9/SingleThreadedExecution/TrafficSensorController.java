/**
 * 
 */
package com.moleksyuk.chapter9.SingleThreadedExecution;

import com.moleksyuk.chapter9.SingleThreadedExecution.TrafficSensor.TrafficObserver;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 18, 2011
 * 
 * @author moleksyuk
 */
public class TrafficSensorController implements TrafficObserver {

	private int vehicleCount = 0;

	public synchronized int getAndClearCount() {
		int count = vehicleCount;
		vehicleCount = 0;
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter9.SingleThreadedExecution.TrafficSensor.TrafficObserver
	 * #vehiclePassed()
	 */
	@Override
	public synchronized void vehiclePassed() {
		vehicleCount++;
	}
}
