package com.moleksyuk.chapter8.Visitor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public interface IVisitor {
	public void visit(Book book);

	public void visit(CD cd);

	public void visit(DVD dvd);
}
