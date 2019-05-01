/**
 * 
 */
package com.moleksyuk.chapter9.Future;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 22, 2011
 * 
 * @author moleksyuk
 */
public class WeatherFuture {

	private Coordinate location;
	private IWeatherFetch fetcher;
	private AsynchronousFuture futureSupport;

	public WeatherFuture(IWeatherFetch fetcher, Coordinate location) {
		this.fetcher = fetcher;
		this.location = location;
		futureSupport = new AsynchronousFuture();
		new Runner().start();
	}

	public boolean check() {
		return futureSupport.checkResult();
	}

	public synchronized IWeatherFetch waitForWeather() throws Exception {
		return (IWeatherFetch) futureSupport.getResult();
	}

	private class Runner extends Thread {

		@Override
		public void run() {
			try {
				IWeatherFetch info = fetcher.fetchWeather(location);
				futureSupport.setResult(info);
			} catch (Exception e) {
				futureSupport.setException(e);
			}
		}
	}
}
