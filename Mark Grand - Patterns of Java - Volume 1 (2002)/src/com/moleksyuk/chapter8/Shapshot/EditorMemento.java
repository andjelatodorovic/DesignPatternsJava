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
public class EditorMemento {

	private final String editorState;

	public EditorMemento(String state) {
		editorState = state;
	}

	public String getSavedState() {
		return editorState;
	}
}
