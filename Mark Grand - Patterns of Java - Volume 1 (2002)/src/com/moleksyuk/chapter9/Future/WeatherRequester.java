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
public class WeatherRequester {

	IWeatherFetch fetcher;

	public WeatherRequester(IWeatherFetch fetcher) {
		this.fetcher = fetcher;
	}

	public synchronized WeatherFuture getWeather(Coordinate location) {
		return new WeatherFuture(fetcher, location);
	}
}
