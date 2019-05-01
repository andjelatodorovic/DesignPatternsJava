package com.moleksyuk.chapter7.CacheManagment;

import com.moleksyuk.chapter7.CacheManagment.EmployeeProfileFetcher;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 11, 2011
 * 
 * @author moleksyuk
 */
public class EmployeeProfileManager {

	private EmployeeCache cache = new EmployeeCache();
	private EmployeeProfileFetcher server = new EmployeeProfileFetcher();

	EmployeeProfile fetchEmployee(EmployeeID id) {
		EmployeeProfile profile = cache.fetchEmployee(id);
		if (profile == null) {
			profile = server.fetchEmployee(id);

			if (profile != null) {
				cache.addEmployee(profile);
			}
		}
		return profile;
	}
}
