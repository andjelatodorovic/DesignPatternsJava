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
public abstract class AbstractTemplateMethod {
	private StringBuilder message;

	abstract protected String buildHeader();

	abstract protected String buildBody();

	abstract protected String buildFooter();

	public final String buildMessage() {
		message = new StringBuilder();
		message.append(buildHeader());
		message.append(buildBody());
		message.append(buildFooter());
		return message.toString();
	}
}
