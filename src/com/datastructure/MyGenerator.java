/**
 * 
 */
package com.datastructure;

/**
 * @author zolanunu
 *
 */
public class MyGenerator implements Generator<String> {
	private String string = "one two three four five six seven eight nine ten eleven";
	private int index = 0;
	public String next() {
		if(index > string.split(" ").length) {
			return "";
		} else {
			return string.split(" ")[index++];
		}
	}
}
