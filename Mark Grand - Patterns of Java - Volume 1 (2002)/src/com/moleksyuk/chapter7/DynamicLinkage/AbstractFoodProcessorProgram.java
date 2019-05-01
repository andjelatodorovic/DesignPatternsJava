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
public abstract class AbstractFoodProcessorProgram {

	private IFoodProcessorProgram environment;

	public void setEnvironment(IFoodProcessorProgram env) {
		this.environment = env;
	}

	protected IFoodProcessorProgram getEnvironment() {
		return environment;
	}

	public abstract String getName();

	public abstract void start();
}
