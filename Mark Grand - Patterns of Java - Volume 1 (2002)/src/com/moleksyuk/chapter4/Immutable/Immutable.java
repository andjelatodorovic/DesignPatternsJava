/**
 * 
 */
package com.moleksyuk.chapter4.Immutable;

import java.util.Date;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 25, 2011
 * 
 * @author moleksyuk
 */
public class Immutable {

	private int x;
	private int y;
	private Date date;

	public Immutable(int x, int y, Date date) {
		this.x = x;
		this.y = y;
		this.date = date;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Date getDate() {
		return new Date(date.getTime());
	}
}
