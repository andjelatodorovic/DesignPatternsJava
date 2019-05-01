/**
 * 
 */
package com.moleksyuk.chapter7.DynamicLinkage;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 9, 2011
 * 
 * @author moleksyuk
 */
public class ConcreteFoodProcessorProgram extends AbstractFoodProcessorProgram {

	@Override
	public void start() {
		double weight = getEnvironment().weight();
		if (weight > 120.0 && weight < 160.0) {
			getEnvironment().mix(4);
		}
	}

	@Override
	public String getName() {
		return "Chocolate Milk";
	}
}
