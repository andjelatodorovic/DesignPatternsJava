/**
 * 
 */
package com.moleksyuk.chapter6.Composite;

import java.awt.Font;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public interface IDocumentElement {

	public CompositeDocumentElement getParent();

	public Font getFont();

	public void setFont(Font font);

	public int getCharLength();
}
