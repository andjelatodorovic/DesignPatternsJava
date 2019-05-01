package com.moleksyuk.chapter8.Shapshot;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 17, 2011
 * 
 * @author moleksyuk
 */
public class Main {

	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.setState("init");
		System.out.println("Initial state: " + editor.getState());
		EditorMemento saved = editor.save();
		editor.setState("changed");
		System.out.println("New state:" + editor.getState());
		editor.restoreToState(saved);
		System.out.println("Restored state:" + editor.getState());
	}
}
