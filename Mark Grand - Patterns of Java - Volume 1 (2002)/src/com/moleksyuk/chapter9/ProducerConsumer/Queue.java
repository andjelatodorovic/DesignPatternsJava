package com.moleksyuk.chapter9.ProducerConsumer;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public class Queue {

	private ArrayList<TroubleTiket> data = new ArrayList<TroubleTiket>();

	public synchronized void push(TroubleTiket tck) {
		data.add(tck);
		notify();
	}

	public synchronized TroubleTiket pull() {
		while (data.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		TroubleTiket tck = data.get(0);
		data.remove(0);
		return tck;
	}

	public int size() {
		return data.size();
	}
}
