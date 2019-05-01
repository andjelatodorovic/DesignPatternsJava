/**
 * 
 */
package com.moleksyuk.chapter6.ReadOnlyInterface;

import java.util.ArrayList;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public class TemperatureData implements ITemperature {

	private double temperature;
	private ArrayList<TemperatureListener> listeners = new ArrayList<TemperatureListener>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter6.ReadOnlyInterface.ITemperature#getTemperature()
	 */
	@Override
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		fireTemperature();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter6.ReadOnlyInterface.ITemperature#addListener(com
	 * .moleksyuk.chapter6.ReadOnlyInterface.ITemperature)
	 */
	@Override
	public void addListener(TemperatureListener listener) {
		listeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter6.ReadOnlyInterface.ITemperature#removeListener(
	 * com.moleksyuk.chapter6.ReadOnlyInterface.ITemperature)
	 */
	@Override
	public void removeListener(TemperatureListener listener) {
		listeners.remove(listener);
	}

	private void fireTemperature() {
		TemperatureEvent evt = new TemperatureEvent(this, temperature);
		for (TemperatureListener listener : listeners) {
			listener.temperatureChanged(evt);
		}

	}
}
