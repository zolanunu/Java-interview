/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class LongPalindromicString {
	public static String longestPalindrome(String s) {
		/**
		 * ¸ÄÔì×Ö·û´®
		 * */
		if(s.isEmpty()||s==null||s.length()==1) {
			return s;
		}
		String loString = s.substring(0,1);
		for(int i = 0; i < s.length(); i++) {
			String temString = help(s, i, i);
			if(temString.length()>loString.length()) {
				loString = temString;
			}
			temString = help(s, i, i+1);
			if(temString.length()>loString.length()) {
				loString = temString;
			}
		}
		return loString;
	}
	
	public static String help(String s, int i, int j) {
		while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)) {
			i--;
			j++;
		}
		return s.substring(i+1,j);
	}
	
	public static void main(String[] args) {
		String s = "cbbd";
		System.out.println(longestPalindrome(s));
	}
}
