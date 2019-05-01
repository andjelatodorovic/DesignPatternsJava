/**
 * 
 */
package com.moleksyuk.chapter5.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 1, 2011
 * 
 * @author moleksyuk
 */
public class ProductCache {
	private static Map<String, Product> products = new HashMap<String, Product>();

	public static Product getProduct(String product) {
		Product cachedProduct = products.get(product);
		return (Product) cachedProduct.clone();
	}

	public static void loadCache() {
		Book b1 = new Book();
		b1.setName("Guliver");
		b1.setDescription("Book description.");
		b1.setPages(100);
		products.put(b1.getName(), b1);
		DVD d1 = new DVD();
		d1.setName("Super Mario");
		d1.setDescription("Play station game");
		d1.setDuration(180);
		products.put(d1.getName(), d1);
	}
}
