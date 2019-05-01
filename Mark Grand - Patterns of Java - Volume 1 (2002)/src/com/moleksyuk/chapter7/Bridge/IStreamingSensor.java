package com.moleksyuk.chapter7.Bridge;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public interface IStreamingSensor extends ISimpleSensor {

	public void setSamplingFrequency(int freq) throws SensorException;

	public void setStreamingSensorListener(IStreamingSensorListener listener);

}
