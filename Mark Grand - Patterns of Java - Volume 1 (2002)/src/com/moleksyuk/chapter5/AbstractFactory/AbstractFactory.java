/**
 * 
 */
package com.moleksyuk.chapter5.AbstractFactory;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 27, 2011
 * 
 * @author moleksyuk
 */
public class AbstractFactory {

	private AbstractFactory() {
	}

	private static AbstractFactory instance = new AbstractFactory();

	public static AbstractFactory getInstance() {
		return instance;
	}

	public IArchitectureToolkit createToolkit(ArchitectureType architecture) {
		if (ArchitectureType.x64.equals(architecture)) {
			return new ArchitectureToolkit_x64();
		} else if (ArchitectureType.x86.equals(architecture)) {
			return new ArchitectureToolkit_x86();
		} else {
			throw new IllegalArgumentException("Not supported architecture "
					+ architecture);
		}
	}
}
