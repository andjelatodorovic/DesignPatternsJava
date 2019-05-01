package com.moleksyuk.chapter8.Visitor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class PostageVisitor implements IVisitor {

	@Override
	public void visit(Book book) {
		System.out.println("Visit book!");
	}

	@Override
	public void visit(CD cd) {
		System.out.println("Visit CD!");
	}

	@Override
	public void visit(DVD dvd) {
		System.out.println("Visit DVD!");
	}

}
