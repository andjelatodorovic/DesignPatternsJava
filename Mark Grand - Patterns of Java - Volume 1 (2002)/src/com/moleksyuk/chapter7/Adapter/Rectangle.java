package com.moleksyuk.chapter7.Adapter;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class Rectangle {

	public void draw(int xUpperLeft, int yUpperLeft, int width, int height) {
		System.out
				.println("Draw rectangle: with start cooridanates coordinates: ["
						+ xUpperLeft
						+ ","
						+ yUpperLeft
						+ "], Width="
						+ width
						+ ", Height=" + height);
	}
}
