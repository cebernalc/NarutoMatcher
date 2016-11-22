/**
 * Combinations.java
 * 
 * Created on Nov 18, 2016, 8:09:09 PM
 * 
 */
package com.cebernal.naruto.test;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Nov 18, 2016
 */
public class TestCombinations {
	public void run(String data, int howMany) {
		choose(data, howMany, new StringBuffer(), 0);
	}

	// n choose k
	private void choose(String data, int k, StringBuffer result, int startIndex) {
		if (result.length() == k) {
			System.out.println(result.toString());
			return;
		}

		for (int i = startIndex; i < data.length()|| startIndex== data.length(); i++) {
			result.append(data.charAt(i%(data.length())));
			choose(data, k, result, i + 1);
			result.setLength(result.length() - 1);
		}
	}

	public static void main(String[] args) {
		TestCombinations t = new TestCombinations();
		t.run("abc", 3);
	}
}
