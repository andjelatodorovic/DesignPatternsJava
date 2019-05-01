package com.moleksyuk.chapter6.Composite;

import java.util.Vector;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 5, 2011
 * 
 * @author moleksyuk
 */
public abstract class CompositeDocumentElement extends AbstractDocumentElement {

	private Vector<IDocumentElement> children = new Vector<IDocumentElement>();
	@SuppressWarnings("unused")
	private int cachedCharLength = -1;

	public IDocumentElement getChild(int index) {
		return children.elementAt(index);
	}

	public synchronized void addChild(IDocumentElement child) {
		synchronized (child) {
			children.addElement(child);
			((AbstractDocumentElement) child).setParent(this);
			changeNotification();
		}
	}

	public synchronized void removeChild(AbstractDocumentElement child) {
		synchronized (child) {
			if (this == child.getParent()) {
				child.setParent(null);
			}
			children.removeElement(child);
			changeNotification();
		}
	}

	public void changeNotification() {
		cachedCharLength = -1;
		if (getParent() != null) {
			getParent().changeNotification();
		}
	}

	@Override
	public int getCharLength() {
		int len = 0;
		for (int i = 0; i < children.size(); i++) {
			AbstractDocumentElement thisChild = (AbstractDocumentElement) children
					.elementAt(i);
			len += thisChild.getCharLength();
		}
		cachedCharLength = len;
		return len;
	}
}
