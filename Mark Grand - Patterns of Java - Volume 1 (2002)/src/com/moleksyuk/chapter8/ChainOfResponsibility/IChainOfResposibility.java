/**
 * 
 */
package com.moleksyuk.chapter8.ChainOfResponsibility;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 12, 2011
 * 
 * @author moleksyuk
 */
public interface IChainOfResposibility {
	public void setNextHandler(IChainOfResposibility handler);

	public void handleRequest(String message);
}
