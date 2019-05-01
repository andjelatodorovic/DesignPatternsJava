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
public class TemperatureEvent {
	TemperatureData temperatureData;
	double temperature;

	public TemperatureEvent(TemperatureData temperatureData, double temperature) {
		this.temperatureData = temperatureData;
		this.temperature = temperature;
	}

}
