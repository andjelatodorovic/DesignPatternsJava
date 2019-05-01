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
public class Book extends Product {
	private int pages;

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPages() {
		return pages;
	}
}
