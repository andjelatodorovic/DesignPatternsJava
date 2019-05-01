/**
 * 
 */
package com.moleksyuk.chapter5.Builder;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Jul 28, 2011
 * 
 * @author moleksyuk
 */
public class Pizza {
	private int size;
	private boolean paperoni;
	private boolean cheese;
	private boolean bacon;

	private Pizza(Builder builder) {
		size = builder.size;
		paperoni = builder.paperoni;
		cheese = builder.cheese;
		bacon = builder.bacon;
	}

	@Override
	public String toString() {
		return "Pizza:\n" + "\tsize=" + size + "\n\tpaperone=" + paperoni
				+ "\n\tcheese=" + cheese + "\n\tbacon=" + bacon;
	}

	public static class Builder {
		// required
		private final int size;

		// optional
		private boolean paperoni;
		private boolean cheese;
		private boolean bacon;

		public Builder(int size) {
			this.size = size;
		}

		public Builder paperoni(boolean value) {
			this.paperoni = value;
			return this;
		}

		public Builder cheese(boolean value) {
			this.cheese = value;
			return this;
		}

		public Builder bacon(boolean value) {
			this.bacon = value;
			return this;
		}

		public Pizza build() {
			return new Pizza(this);
		}
	}
}
