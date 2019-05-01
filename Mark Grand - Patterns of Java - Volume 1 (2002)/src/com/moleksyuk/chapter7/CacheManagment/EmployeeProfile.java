package com.moleksyuk.chapter7.CacheManagment;

import java.util.Locale;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 11, 2011
 * 
 * @author moleksyuk
 */
public class EmployeeProfile {

	private EmployeeID id;
	private Locale locale;
	private boolean supervisor;
	private String name;

	public EmployeeProfile(EmployeeID id, Locale locale, boolean supervisor,
			String name) {
		this.id = id;
		this.locale = locale;
		this.supervisor = supervisor;
		this.name = name;
	}

	public EmployeeID getID() {
		return id;
	}

	public Locale getLocale() {
		return locale;
	}

	public boolean isSupervisor() {
		return supervisor;
	}

	public String getName() {
		return name;
	}
}
