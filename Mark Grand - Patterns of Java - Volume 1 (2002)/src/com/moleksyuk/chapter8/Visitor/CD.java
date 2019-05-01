package com.moleksyuk.chapter8.Visitor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 15, 2011
 * 
 * @author moleksyuk
 */
public class CD implements IVisitable {

	private int records;
	private double price;

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
