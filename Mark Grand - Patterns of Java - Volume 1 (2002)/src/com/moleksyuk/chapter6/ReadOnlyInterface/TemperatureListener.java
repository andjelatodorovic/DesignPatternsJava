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
public interface TemperatureListener extends ITemperature {

	public void temperatureChanged(TemperatureEvent evt);

}
