package com.moleksyuk.chapter7.Adapter;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class Line {

	public void draw(int xStartPoint, int yStartPoint, int xEndPoint,
			int yEndPoint) {
		System.out.println("Draw line with coordinates: [" + xStartPoint + ","
				+ yStartPoint + "],[" + xEndPoint + "," + yEndPoint + "]");
	}
}
