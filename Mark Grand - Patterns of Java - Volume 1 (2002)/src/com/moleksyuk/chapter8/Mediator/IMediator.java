/**
 * 
 */
package com.moleksyuk.chapter8.Mediator;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 16, 2011
 * 
 * @author moleksyuk
 */
public interface IMediator {
	public void send(String message, Colleague colleague);
}
