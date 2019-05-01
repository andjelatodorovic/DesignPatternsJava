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
public class Main {

	public static void main(String[] args) {
		AbstractTemplateMethod html = new HtmlBuilder();
		System.out.println(html.buildMessage());

		AbstractTemplateMethod soap = new SoapBuilder();
		System.out.println(soap.buildMessage());
	}

}
