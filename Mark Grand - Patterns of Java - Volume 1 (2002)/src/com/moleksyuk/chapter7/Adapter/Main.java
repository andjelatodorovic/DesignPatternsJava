package com.moleksyuk.chapter7.Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		List<IShape> shapes = new ArrayList<IShape>();
		shapes.add(new LineAdapter());
		shapes.add(new RectangleAdapter());

		for (IShape shape : shapes) {
			shape.draw(10, 10, 30, 30);
		}

	}

}
