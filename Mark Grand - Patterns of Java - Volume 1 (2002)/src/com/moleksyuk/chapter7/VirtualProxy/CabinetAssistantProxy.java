/**
 * 
 */
package com.moleksyuk.chapter7.VirtualProxy;

import java.lang.reflect.Constructor;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 10, 2011
 * 
 * @author moleksyuk
 */
public class CabinetAssistantProxy implements ICabinetAssistant {

	private ICabinetAssistant assistant;
	private String assistantParams;

	public CabinetAssistantProxy(String assistantParams) {
		this.assistantParams = assistantParams;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ICabinetAssistant getAssistant() {
		if (assistant == null) {
			try {
				Class clazz = Class
						.forName("com.moleksyuk.chapter7.VirtualProxy.ConcreteCabinetAssistant");
				Constructor constructor;

				Class[] params = new Class[] { String.class };
				constructor = clazz.getConstructor(params);

				Object[] actuals = new Object[] { assistantParams };
				assistant = (ICabinetAssistant) constructor
						.newInstance(actuals);
			} catch (Exception e) {
			}

			if (assistant == null) {
				throw new RuntimeException(
						"Cant instantiate com.moleksyuk.chapter7.VirtualProxy.ConcreteCabinetAssistant");
			}
		}
		return assistant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter7.VirtualProxy.ICabinetAssistant#operation1()
	 */
	@Override
	public void operation1() {
		getAssistant().operation1();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter7.VirtualProxy.ICabinetAssistant#operation2()
	 */
	@Override
	public void operation2() {
		getAssistant().operation2();
	}

}
