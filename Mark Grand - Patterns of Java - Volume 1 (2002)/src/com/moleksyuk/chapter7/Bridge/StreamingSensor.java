package com.moleksyuk.chapter7.Bridge;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Vector;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 7, 2011
 * 
 * @author moleksyuk
 */
public class StreamingSensor extends SimpleSensor implements Runnable,
		IStreamingSensorListener {

	private DataInputStream consumer;
	private DataOutputStream producer;

	private Vector<IStreamingSensorListener> listeners = new Vector<IStreamingSensorListener>();

	StreamingSensor(IStreamingSensor sensor) throws SensorException {
		super(sensor);

		PipedInputStream pipedInput = new PipedInputStream();
		consumer = new DataInputStream(pipedInput);

		PipedOutputStream pipedOutput;
		try {
			pipedOutput = new PipedOutputStream(pipedInput);

		} catch (IOException e) {
			throw new SensorException("Pipe createion failed");
		}
		producer = new DataOutputStream(pipedOutput);
		new Thread(this).start();
	}

	public void setSamplingFrequency(int freq) throws SensorException {
		IStreamingSensor sensor = (IStreamingSensor) getSensor();
		sensor.setSamplingFrequency(freq);
	}

	@Override
	public void processMeasurement(int value) {
		try {
			producer.writeInt(value);
		} catch (IOException e) {

		}
	}

	public void addStreamingSensorListener(IStreamingSensorListener listener) {
		listeners.add(listener);
	}

	public void removeStreamingSensorListener(IStreamingSensorListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void run() {
		while (true) {
			int value;
			try {
				value = consumer.readInt();
			} catch (IOException e) {
				return;
			}
			for (int i = 0; i < listeners.size(); i++) {
				IStreamingSensorListener listener = listeners.elementAt(i);
				listener.processMeasurement(value);
			}
		}
	}

}
