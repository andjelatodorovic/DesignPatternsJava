/**
 * 
 */
package com.moleksyuk.chapter6.ReadOnlyInterface;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public interface ITemperature {

	public double getTemperature();

	public void addListener(TemperatureListener listener);

	public void removeListener(TemperatureListener listener);

}
