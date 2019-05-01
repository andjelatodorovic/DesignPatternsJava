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
class Image implements IGraphic {
	@SuppressWarnings("unused")
	private byte[] data;

	public Image(String fileName) {
		data = loadImage(fileName);
	}

	@Override
	public void draw() {
		System.out.println("     *");
		System.out.println("    *  * ");
		System.out.println("   *    * ");
		System.out.println("  *      * ");
		System.out.println(" *        * ");
		System.out.println("************");
	}

	private byte[] loadImage(String fileName) {
		return null;
	}
}
