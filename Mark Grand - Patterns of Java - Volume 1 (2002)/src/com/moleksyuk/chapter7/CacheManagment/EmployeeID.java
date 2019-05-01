package com.moleksyuk.chapter7.CacheManagment;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 11, 2011
 * 
 * @author moleksyuk
 */
public class EmployeeID {
	private String id;

	public EmployeeID(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof EmployeeID && id.equals(((EmployeeID) obj).id));
	}

	@Override
	public String toString() {
		return id;
	}
}
