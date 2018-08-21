package com.java.leetcode.coding;

import java.util.Scanner;

public class MinSequence {
	// 最小序列化
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n = inScanner.nextInt();
		int k = inScanner.nextInt();
		int[] m = new int[n];
		for(int i = 0; i < n; i++) {
			m[i] = inScanner.nextInt();
		}
		System.out.println(Math.ceil((double)(n-1)/(k-1)));
		inScanner.close();
	}
}
