/**
 * 
 */
package com.moleksyuk.chapter7.DynamicLinkage;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 9, 2011
 * 
 * @author moleksyuk
 */
public interface IFoodProcessorProgram {

	public void slice(int width);

	public void mix(int speed);

	public double weight();

	public void display(String name);
}
