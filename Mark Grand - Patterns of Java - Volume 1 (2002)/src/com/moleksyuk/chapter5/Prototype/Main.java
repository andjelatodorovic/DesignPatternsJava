/**
 * 
 */
package com.moleksyuk.chapter5.Prototype;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 1, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		ProductCache.loadCache();

		Book clonedBook = (Book) ProductCache.getProduct("Guliver");
		System.out.println("BOOK:");
		System.out.println(clonedBook.getName());
		System.out.println(clonedBook.getDescription());
		System.out.println(clonedBook.getPages());
		System.out.println();

		DVD clonedDVD = (DVD) ProductCache.getProduct("Super Mario");
		System.out.println("DVD:");
		System.out.println(clonedDVD.getName());
		System.out.println(clonedDVD.getDescription());
		System.out.println(clonedDVD.getDuration());

	}

}
