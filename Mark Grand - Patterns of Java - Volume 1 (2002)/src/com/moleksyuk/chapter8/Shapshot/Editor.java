/**
 * 
 */
package com.moleksyuk.chapter8.Shapshot;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 17, 2011
 * 
 * @author moleksyuk
 */
public class Editor {

	private String editorContents;

	public void setState(String contents) {
		this.editorContents = contents;
	}

	public String getState() {
		return editorContents;
	}

	public EditorMemento save() {
		return new EditorMemento(editorContents);
	}

	public void restoreToState(EditorMemento memento) {
		editorContents = memento.getSavedState();
	}
}
