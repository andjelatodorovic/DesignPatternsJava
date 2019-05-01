/**
 * 
 */
package com.moleksyuk.chapter9.ProducerConsumer;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public class Dispatcher implements Runnable {

	private Queue queue;

	public Dispatcher(Queue queue) {
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		@SuppressWarnings("unused")
		TroubleTiket ticket = queue.pull();
	}

}
