package com.moleksyuk.chapter8.Visitor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class Book implements IVisitable {
	private double price;
	private double weight;

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
