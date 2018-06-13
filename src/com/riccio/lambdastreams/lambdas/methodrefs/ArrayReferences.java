package com.riccio.lambdastreams.lambdas.methodrefs;

public class ArrayReferences {
	interface StringArray {
		String[] create(int size);
	}

	private void testArrayConstructorReferences() {
		StringArray sArray = (size) -> new String[size];
		StringArray sArray2 = String[]::new;
	}

	public static void main(String[] args) {

	}

}
