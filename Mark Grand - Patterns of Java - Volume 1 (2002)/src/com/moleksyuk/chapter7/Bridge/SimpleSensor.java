package com.moleksyuk.chapter7.Bridge;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class SimpleSensor {

	private ISimpleSensor sensor;

	SimpleSensor(ISimpleSensor sensor) {
		this.sensor = sensor;
	}

	protected ISimpleSensor getSensor() {
		return sensor;
	}

	public int getValue() throws SensorException {
		return sensor.getValue();
	}

}
