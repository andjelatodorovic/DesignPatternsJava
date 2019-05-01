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
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Immutable position = new Immutable(0, 0, new Date());
		System.out.println("Position x=" + position.getX());
		System.out.println("Position y=" + position.getY());
		System.out.println("Position date=" + position.getDate());
		Date mydate = position.getDate();
		mydate.setYear(2020);
		System.out.println("Date after modification date=" + mydate);
		System.out.println("Position date=" + position.getDate());

	}

}
