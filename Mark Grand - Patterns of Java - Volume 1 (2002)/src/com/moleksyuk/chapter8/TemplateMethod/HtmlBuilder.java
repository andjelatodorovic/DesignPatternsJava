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
public class HtmlBuilder extends AbstractTemplateMethod {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter8.TemplateMethod.AbstractTemplateMethod#buildHeader
	 * ()
	 */
	@Override
	protected String buildHeader() {
		return "<html>\r\n\t<head>\r\n\t\t<title>My first HTML page</title>\r\n\t</head>\r\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.moleksyuk.chapter8.TemplateMethod.AbstractTemplateMethod#buildBody()
	 */
	@Override
	protected String buildBody() {
		return "\t<body> HTML Body </Body>\r\n";
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
		return "</html>";
	}

}
