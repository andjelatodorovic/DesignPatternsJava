package com.moleksyuk.chapter7.Bridge;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class AveragingSensor extends SimpleSensor {

	public AveragingSensor(IAveragingSensor sensor) {
		super(sensor);
	}

	public void beginAverage() throws SensorException {
		((IAveragingSensor) getSensor()).beginAverage();
	}
}
