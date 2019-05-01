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
public class Main {

	public static void main(String[] args) {
		AbstractFactory af = AbstractFactory.getInstance();
		IArchitectureToolkit toolkit_x64 = af
				.createToolkit(ArchitectureType.x64);
		System.out.println(toolkit_x64.createCpu().getClass());
		System.out.println(toolkit_x64.createMmu().getClass());
		IArchitectureToolkit toolkit_x86 = af
				.createToolkit(ArchitectureType.x86);
		System.out.println(toolkit_x86.createCpu().getClass());
		System.out.println(toolkit_x86.createMmu().getClass());
	}

}
