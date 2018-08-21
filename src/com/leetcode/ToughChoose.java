package com.java.leetcode.coding;

import java.util.Scanner;

public class ToughChoose {
	/**
	 * 一组序列，做除2乘3的操作
	 * 每次都必须有一个数除2，乘3不影响被2整除的次数，所以求出所有的数能被2整除的次数，加起来就是结果。
	 * */
	public static int last(int x) {
		if(x <= 1) {
			return 0;
		}
		int z = 0;
		while(x % 2 == 0 && x >= 1) {
			x /= 2;
			z++;
		}
		return z;
	}
	
	public static int sugerNumber(int[] m, int n) {
		if(n <= 0) {
			return  0;
		}
		int r = 0;
		for(int i = 0; i < n; i++) {
			r += last(m[i]);
		}
		System.out.println(r);
		return r;
	}
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n = inScanner.nextInt();
		int[] num=new int[n];
		for(int i = 0; i<n;i++) {
			num[i]=inScanner.nextInt();
		}
		System.out.println(sugerNumber(num, n));
	}
	
}
