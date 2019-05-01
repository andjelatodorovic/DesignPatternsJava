/**
 * 
 */
package com.moleksyuk.chapter4.AbstractSuperClass;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 21, 2011
 * 
 * @author moleksyuk
 */
public class ArrayListIterator<E> extends AbstractSuperClass<E> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return ArrayListIterator.class.getName();
	}
}
