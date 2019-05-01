package com.moleksyuk.chapter4.InterfaceAndAbstractClass;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 2, 2011
 * 
 * @author moleksyuk
 */
public abstract class AbstractDoubleLink implements IDoubleLink {

	private IDoubleLink previous;
	private IDoubleLink next;

	@Override
	public IDoubleLink getNext() {
		return next;
	}

	@Override
	public void setNext(IDoubleLink next) {
		this.next = next;
	}

	@Override
	public IDoubleLink getPrevious() {
		return previous;
	}

	@Override
	public void setPrevious(IDoubleLink previous) {
		this.previous = previous;
	}
}
