/**
 * 
 */
package com.java.leetcode.coding;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zolanunu
 *
 */
public class ColorfulBlock {
	/**
	 * ²ÊÉ«µÄ×©¿é
	 * */
	
	public static int colorfulBlock(String s) {
		Set<Character> set = new HashSet<>();
		char[] sc = s.toCharArray();
		int count = 0;
		for(int i = 0; i < sc.length; i++) {
			set.add(sc[i]);
		}
		count = set.size();
		if(count > 2) {
			return 0;
		} else if(count == 2) {
			return 2;
		} else {
			return 1;
		}
	}
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String s = null;
//		while((s = in.nextLine()) != null) {
//			int i = colorfulBlock(s);
//			System.out.println(i);
//		}
		
		String string = "hello";
		int hash = 0;
		for(int i = 0; i < string.length(); i++) {
			hash = 31 *  hash + string.charAt(i);
		}
		System.out.println(hash);
	}
}
