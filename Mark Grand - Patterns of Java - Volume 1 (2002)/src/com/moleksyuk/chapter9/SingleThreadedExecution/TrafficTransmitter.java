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
public class TrafficTransmitter implements Runnable {

	private TrafficSensorController controller;
	private Thread myThread;

	public TrafficTransmitter(TrafficSensorController controller) {
		this.controller = controller;
		myThread = new Thread(this);
		myThread.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {
			try {
				myThread.sleep(60 * 1000);
				transmit(controller.getAndClearCount());
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

	private native void transmit(int count);

}
