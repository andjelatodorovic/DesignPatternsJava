/**
 * 
 */
package com.moleksyuk.chapter9.TwoPhaseTermination;

import java.net.Socket;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public class Session implements Runnable {

	private Thread myThread;
	private Portfolio portfolio;
	private Socket mySocket;

	public Session(Socket socket) {
		myThread = new Thread(this);
		this.mySocket = socket;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		initialize();
		while (!myThread.interrupted()) {
			portfolio.sendTransactionsToClient(mySocket);
		}
		shutDown();
	}

	public void interrupt() {
		myThread.interrupt();
	}

	private void initialize() {

	}

	private void shutDown() {

	}
}
