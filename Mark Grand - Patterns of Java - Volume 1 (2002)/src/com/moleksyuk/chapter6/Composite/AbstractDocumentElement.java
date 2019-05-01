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
public abstract class AbstractDocumentElement implements IDocumentElement {

	private Font font;
	private CompositeDocumentElement parent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.chapter6.Composite.IDocumentElement#getParent()
	 */
	@Override
	public CompositeDocumentElement getParent() {
		return parent;
	}

	protected void setParent(CompositeDocumentElement parent) {
		this.parent = parent;
	}

	@Override
	public Font getFont() {
		if (font != null) {
			return font;
		} else if (parent != null) {
			return parent.getFont();
		} else {
			return null;
		}
	}

	@Override
	public void setFont(Font font) {
		this.font = font;
	}

	@Override
	public abstract int getCharLength();

}
