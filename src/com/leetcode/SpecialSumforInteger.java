package com.leetcode;
public class SpecialSumforInteger {
	public static int add(int n, int m) {
		int s, k;
		do {
			s = n ^ m;
			k = (n & m) << 1;
			n = s;
			m = k;
			System.out.println(s + " " + k);
		} while (m != 0);
		return n;
	}
	
	public static void main(String[] args) {
		int s = add(86, 12);
		System.out.println(s);
	}
}
