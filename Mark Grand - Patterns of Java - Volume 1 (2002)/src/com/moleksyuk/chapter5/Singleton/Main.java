/**
 * 
 */
package com.moleksyuk.chapter5.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 2, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getClass());
		SingletonLazy singletonlazy = SingletonLazy.getInstance();
		System.out.println(singletonlazy.getClass());

		ExecutorService es = Executors.newFixedThreadPool(3);
		for (byte i = 0; i < 3; i++) {
			es.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(SingletonThreadSafe.getInstance());
				}
			});
		}

		es.shutdown();
	}
}
