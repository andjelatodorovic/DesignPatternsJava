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
@SuppressWarnings("rawtypes")
public class SoftCleanupReference extends SoftReference implements ICleanup {

	@SuppressWarnings("unchecked")
	public SoftCleanupReference(Object obj, ReferenceQueue refQueue,
			ICleanup cleanup) {
		super(obj, refQueue);
	}

	@Override
	public void extricate() {
		// TODO Auto-generated method stub
	}

}
