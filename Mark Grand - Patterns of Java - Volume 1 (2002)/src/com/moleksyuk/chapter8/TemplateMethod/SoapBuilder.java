/**
 * 
 */
package com.moleksyuk.chapter8.TemplateMethod;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 12, 2011
 * 
 * @author moleksyuk
 */
public class SoapBuilder extends AbstractTemplateMethod {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter8.TemplateMethod.AbstractTemplateMethod#buildHeader
	 * ()
	 */
	@Override
	protected String buildHeader() {
		return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter8.TemplateMethod.AbstractTemplateMethod#buildBody()
	 */
	@Override
	protected String buildBody() {
		return "\t<Body>\r\n\t\t<helloWorld/>\r\n\t</Body>\r\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter8.TemplateMethod.AbstractTemplateMethod#buildFooter
	 * ()
	 */
	@Override
	protected String buildFooter() {
		return "</Envelope>";
	}

}
