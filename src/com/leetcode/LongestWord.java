package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWord {
	public static String longestWord(String[] words) {
		Arrays.sort(words);
		HashSet<String> set = new HashSet<String>();
		String res = "";
		for(String s : words) {
			if(s.length() == 1 || set.contains(s.substring(0, s.length()-1))) {
				res = (s.length() > res.length()) ? s:res;
				set.add(s);
			}
		}
		return res;
	}
}
