package com.moleksyuk.chapter8.Visitor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public interface IVisitable {
	public void accept(IVisitor visitor);
}
