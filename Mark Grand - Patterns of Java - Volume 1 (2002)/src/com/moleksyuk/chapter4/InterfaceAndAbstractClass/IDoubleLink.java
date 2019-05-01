package com.moleksyuk.chapter4.InterfaceAndAbstractClass;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 3, 2011
 * 
 * @author moleksyuk
 */
public interface IDoubleLink {

	public IDoubleLink getNext();

	public void setNext(IDoubleLink next);

	public IDoubleLink getPrevious();

	public void setPrevious(IDoubleLink previous);
}
