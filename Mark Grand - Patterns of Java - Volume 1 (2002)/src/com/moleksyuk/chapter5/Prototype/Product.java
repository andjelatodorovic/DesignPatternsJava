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
public abstract class Product implements Cloneable {

	private String name;
	private String description;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
