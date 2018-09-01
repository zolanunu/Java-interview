package com.leetcode;


public class LongestCommonPrefix {
	/**
	 * 字符串数组中的所有字符串的前缀
	 * */
	public String longestCommonString(String[] strs) {
		if(strs.length == 0 || strs == null) {
			return "";
		}
		String prefix = strs[0];
		
		for(int i = 1; i < strs.length;) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					return "";
				}
			}
			
		}
		return prefix;
	}
	
	public String longestCommonString1(String[] strs) {
		if(strs.length == 0 || strs == null) {
			return "";
		}
		for(int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
