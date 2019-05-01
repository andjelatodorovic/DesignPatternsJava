/**
 * 
 */
package com.moleksyuk.chapter9.ReadWriteLock;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class Bid {

	private int bid = 0;
	private ReadWriteLock lockManager = new ReadWriteLock();

	public int getBid() throws InterruptedException {
		lockManager.readLock();
		int bid = this.bid;
		lockManager.done();
		return bid;
	}

	public void setBid(int bid) throws InterruptedException {
		lockManager.writeLock();
		if (bid > this.bid) {
			this.bid = bid;
		}
		lockManager.done();
	}
}
