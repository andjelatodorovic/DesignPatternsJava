/**
 * 
 */
package com.moleksyuk.chapter7.DynamicLinkage;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 9, 2011
 * 
 * @author moleksyuk
 */
public class FoodProcessorEnvironment implements IFoodProcessorProgram {

	private static final URL[] classPath;
	static {
		try {
			classPath = new URL[] { new URL("file://bin") };
		} catch (MalformedURLException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter7.DynamicLinkage.IFoodProcessorProgram#slice(int)
	 */
	@Override
	public void slice(int width) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter7.DynamicLinkage.IFoodProcessorProgram#mix(int)
	 */
	@Override
	public void mix(int speed) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter7.DynamicLinkage.IFoodProcessorProgram#weight()
	 */
	@Override
	public double weight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter7.DynamicLinkage.IFoodProcessorProgram#mix(int)
	 */
	@Override
	public void display(String name) {
		// TODO Auto-generated method stub
	}

	void run(String programName) {
		URLClassLoader classLoader = new URLClassLoader(classPath);
		Class<?> programClass;
		try {
			programClass = classLoader.loadClass(programName);
		} catch (ClassNotFoundException e) {
			return;
		}
		AbstractFoodProcessorProgram program;
		try {
			program = (AbstractFoodProcessorProgram) programClass.newInstance();
		} catch (Exception e) {
			return;
		}
		program.setEnvironment(this);
		display(program.getName());
		program.start();
	}
}
