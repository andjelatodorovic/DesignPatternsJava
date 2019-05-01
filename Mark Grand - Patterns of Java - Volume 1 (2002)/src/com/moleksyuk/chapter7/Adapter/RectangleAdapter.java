package com.moleksyuk.chapter7.Adapter;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class RectangleAdapter implements IShape {

	private Rectangle adaptee = new Rectangle();

	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		adaptee.draw(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
	}

}
