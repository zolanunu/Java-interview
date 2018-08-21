/**
 * 
 */
package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zolanunu
 *
 */
public class StringPieces {
	public static int stringPieces(String s, int n) {
		List<Integer> list = new ArrayList<Integer>();
		int count = 1;
		for(int i = 1; i < n; i++) {
			if(s.charAt(i) == s.charAt(i-1)){
				count += 1;
			} else {
				list.add(count);
				count = 1;
			}
		}
		int sum  = 0;
		for(Integer item : list) {
			System.out.print(item+", ");
			sum = sum + item;
		}
		
		return sum / n;
	}
	public static void main(String[] args) {
		String string = "aaabbaaac";
		int s = stringPieces(string, string.length());
		System.out.println(s);
	}
}
