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
public class ArchitectureToolkit_x86 implements IArchitectureToolkit {

	@Override
	public CPU createCpu() {
		return new CPU_x86();
	}

	@Override
	public MMU createMmu() {
		return new MMU_x86();
	}

}
