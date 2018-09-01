/**
 * 
 */
package com.leetcode;


import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class ExChange01Char {
	public static int exChange01Char(String s) {
		int max = 0;
		int count = 1;
		//ArrayList<Integer> countlist = new ArrayList<>();
		char[] sc = s.toCharArray();
		for(int i = 1; i < sc.length; i++) {
			if(sc[i] != sc[i - 1]) {
				count++;
				continue;
			} else {
				if(count > max) {
					max = count;
				}
				count = 1;
				//countlist.add(count);
			}
		}
		if(count > max) {
			max = count;
		}
		return max;
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		System.out.println(string.substring(0, 3));
		int m = exChange01Char(string);
		System.out.println(m);
	}
}
