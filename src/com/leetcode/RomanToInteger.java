package com.leetcode;

import java.util.HashMap;

public class RomanToInteger {
	public static int romanToInteger(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] integer = {1, 5, 10, 50, 100, 500, 1000};
		for(int i = 0; i < roman.length; i++) {
			hashMap.put(roman[i], integer[i]);
		}
		char[] s = str.toCharArray();
		int result = 0;
		if(s.length == 1) {
			result += hashMap.get(s[0]);
			return result;
		}
		for(int i = 0; i < s.length; i++) {
			if( i + 1 < s.length && (((s[i] == 'I' && (s[i+1] == 'V' || s[i+1] == 'X')) 
			|| (s[i] == 'X' && (s[i+1] == 'L' || s[i+1] == 'C'))
			||(s[i] == 'C' && (s[i+1] == 'D' || s[i+1] == 'M'))))) {
				result += hashMap.get(s[i+1]) - hashMap.get(s[i]);
				i = i + 1;
			} else {
				result += hashMap.get(s[i]); 
			}
			System.out.println("result = " + result + "i  = " + i);
		}
		return result;
	}
	public static void main(String[] args) {
		String string = "MCMXCIV";
		System.out.println(romanToInteger(string));
	}
}
