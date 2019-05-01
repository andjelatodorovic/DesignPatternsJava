/**
 * 
 */
package com.moleksyuk.chapter9.Future;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class AsynchronousFuture {

	private Object result;
	private boolean resultIsSet;
	private Exception problem;

	public boolean checkResult() {
		return resultIsSet;
	}

	public synchronized Object getResult() throws Exception {
		while (!resultIsSet) {
			wait();
		}
		if (problem != null) {
			throw problem;
		}
		return result;
	}

	public synchronized void setResult(Object result) {
		if (resultIsSet) {
			String msg = "Result is already set";
			throw new IllegalArgumentException(msg);
		}
		this.result = result;
		resultIsSet = true;
		notifyAll();
	}

	public synchronized void setException(Exception e) {
		problem = e;
		resultIsSet = true;
		notifyAll();
	}
}
