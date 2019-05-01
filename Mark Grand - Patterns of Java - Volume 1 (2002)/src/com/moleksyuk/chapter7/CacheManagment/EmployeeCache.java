package com.moleksyuk.chapter7.CacheManagment;

import java.lang.ref.SoftReference;
import java.util.Hashtable;
import java.util.Map;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 11, 2011
 * 
 * @author moleksyuk
 */
public class EmployeeCache {

	private Map<EmployeeID, LinkedList> cache = new Hashtable<EmployeeID, LinkedList>();
	private final int MAX_CACHE_SIZE = 80;
	private int currentCacheSize = 0;
	private CleanupQueue myCleanup = new CleanupQueue();
	LinkedList mru;
	LinkedList lru;

	public void addEmployee(EmployeeProfile emp) {
		EmployeeID id = emp.getID();
		if (cache.get(id) == null) {
			if (currentCacheSize == 0) {
				lru = mru = new LinkedList(emp);
			} else {
				LinkedList newLink;
				if (currentCacheSize >= MAX_CACHE_SIZE) {
					newLink = lru;
					lru = newLink.previous;
					cache.remove(id);
					currentCacheSize--;
					lru.next = null;
					newLink.setProfile(emp);
				} else {
					newLink = new LinkedList(emp);
				}
				newLink.next = mru;
				mru.previous = newLink;
				newLink.previous = null;
				mru = newLink;
			}
			cache.put(id, mru);
			currentCacheSize++;
		} else {
			fetchEmployee(id);
		}
	}

	EmployeeProfile fetchEmployee(EmployeeID id) {
		myCleanup.cleanup();

		LinkedList foundLink = (LinkedList) cache.get(id);
		if (foundLink == null) {
			return null;
		}
		if (mru != foundLink) {
			if (foundLink == lru) {
				lru = foundLink.previous;
				lru.next = null;
			}
			if (foundLink.previous != null) {
				foundLink.previous.next = foundLink.next;
			}
			if (foundLink.next != null) {
				foundLink.next.previous = foundLink.previous;
			}
			mru.previous = foundLink;
			foundLink.previous = null;
			mru = foundLink;
		}
		return foundLink.getProfile();
	}

	void removeEmployee(EmployeeID id) {
		LinkedList foundLink = (LinkedList) cache.get(id);
		if (foundLink != null) {
			if (mru == foundLink) {
				mru = foundLink.next;
			}
			if (foundLink == lru) {
				lru = foundLink.previous;
			}
			if (foundLink.previous != null) {
				foundLink.previous.next = foundLink.next;
			}
			if (foundLink.next != null) {
				foundLink.next.previous = foundLink.previous;
			}
		}
	}

	private class LinkedList implements ICleanup {
		@SuppressWarnings("rawtypes")
		SoftReference profileReference;
		LinkedList previous;
		LinkedList next;

		LinkedList(EmployeeProfile profile) {
			setProfile(profile);
		}

		void setProfile(EmployeeProfile profile) {
			profileReference = myCleanup.createSoftReference(profile, this);
		}

		EmployeeProfile getProfile() {
			return (EmployeeProfile) profileReference.get();
		}

		@Override
		public void extricate() {
			EmployeeProfile profile = (EmployeeProfile) profileReference.get();
			removeEmployee(profile.getID());
		}
	}
}
