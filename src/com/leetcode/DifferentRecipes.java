package com.java.leetcode.coding;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DifferentRecipes {
	/**
	 * 完成多种料理需要多少种不同的材料
	 * */
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		String string;
		string = inScanner.next();
		while(string !=null) {
			if(!string.equals("#")) {
			set.add(string);
			
			} else {
				break;
			}
			string = inScanner.next();
		}
		System.out.println(set.size());
		inScanner.close();
	}
}
