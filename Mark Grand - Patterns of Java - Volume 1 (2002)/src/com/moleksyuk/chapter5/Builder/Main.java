/**
 * 
 */
package com.moleksyuk.chapter5.Builder;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 28, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		Pizza pizza = new Pizza.Builder(10).bacon(true).cheese(false)
				.paperoni(true).build();
		System.out.println(pizza);
	}

}
