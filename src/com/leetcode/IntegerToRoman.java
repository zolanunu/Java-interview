/**
 * 
 */
package com.java.leetcode.coding;

import java.util.HashMap;

/**
 * @author zolanunu
 * 
 */
public class IntegerToRoman {
	public static String intToRoman(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				System.out.println("num = " + num);
				num -= values[i];
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}
	
	public static int romanToInteger(String roman) {
		int inte = 0;
		
		return 0;
	}
	public static void main(String[] args) {
		String s= intToRoman(50);
		//HashMap<Integer, String>
		System.out.println(s);
	}
}
