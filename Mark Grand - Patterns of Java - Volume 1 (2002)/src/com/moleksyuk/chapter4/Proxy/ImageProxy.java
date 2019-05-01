/**
 * 
 */
package com.moleksyuk.chapter4.Proxy;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 26, 2011
 * 
 * @author moleksyuk
 */
public class ImageProxy implements IGraphic {

	private String fileName;
	private Image img;

	public ImageProxy(String fileName) {
		this.fileName = fileName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moleksyuk.Proxy.IGraphic#draw()
	 */
	@Override
	public void draw() {
		if (img == null) {
			img = new Image(fileName);
		}

		img.draw();
	}

}
