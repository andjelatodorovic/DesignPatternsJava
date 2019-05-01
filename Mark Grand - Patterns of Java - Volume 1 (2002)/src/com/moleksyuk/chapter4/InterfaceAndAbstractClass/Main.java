package com.moleksyuk.chapter4.InterfaceAndAbstractClass;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 2, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		IDoubleLink simpleList = new SimpleDoubleLinkedList();
		// Working with SimpleDoubleLinkedList class

		IDoubleLink complexList = new ComplexDoubleLinkedList();
		// Working with ComplexDoubleLinkedList class.
	}

}
