/**
 * 
 */
package com.moleksyuk.chapter4.AbstractSuperClass;

import java.util.Iterator;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 21, 2011
 * 
 * @author moleksyuk
 */
public abstract class AbstractSuperClass<E> implements Iterator<E> {

	Object element;

	/*
	 * Common implementation for all iterators that extends AbstractSuperClass.
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"This operation is not supported by " + this.toString()
						+ " iterator");
	}
}
