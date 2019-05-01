package com.moleksyuk.chapter8.Visitor;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<IVisitable> items = new ArrayList<IVisitable>();
		items.add(new Book());
		items.add(new CD());
		items.add(new DVD());

		PostageVisitor visitor = new PostageVisitor();
		for (IVisitable item : items) {
			item.accept(visitor);
		}
	}

}
