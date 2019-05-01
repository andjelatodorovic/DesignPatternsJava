package com.moleksyuk.chapter7.CacheManagment;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 11, 2011
 * 
 * @author moleksyuk
 */
public class CleanupQueue {

	@SuppressWarnings("rawtypes")
	private ReferenceQueue refQueue = new ReferenceQueue();
	private boolean cleaning;

	@SuppressWarnings("rawtypes")
	public SoftReference createSoftReference(Object obj, ICleanup cleanup) {
		return new SoftCleanupReference(obj, refQueue, cleanup);
	}

	public void cleanup() {
		synchronized (this) {
			if (cleaning) {
				return;
			}
			cleaning = true;
		}
		try {
			while (refQueue.poll() != null) {
				SoftCleanupReference r = (SoftCleanupReference) refQueue
						.remove();
				r.extricate();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {
			cleaning = false;
		}
	}
}
