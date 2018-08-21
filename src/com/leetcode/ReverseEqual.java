/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ReverseEqual {
	public boolean checkReverseEqual(String s1, String s2) {
		int len = s1.length();
		if(len == s2.length() && len > 0) {
			String s = s1 + s2;
			return true;
		}
		return false;
	}
}
