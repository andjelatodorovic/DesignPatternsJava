package com.moleksyuk.chapter9.GuardedSuspension;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 19, 2011
 * 
 * @author moleksyuk
 */
public class Queue<T> {

	private ArrayList<T> data = new ArrayList<T>();

	public synchronized void put(T o) {
		data.add(o);
		notify();
	}

	public synchronized T get() {
		while (data.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		T obj = data.get(0);
		data.remove(0);
		return obj;
	}
}
