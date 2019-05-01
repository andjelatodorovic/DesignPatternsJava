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
public class Client implements Runnable {

	private Queue queue;

	public Client(Queue queue) {
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		TroubleTiket ticket = new TroubleTiket();

		// some code

		queue.push(ticket);

	}

}
