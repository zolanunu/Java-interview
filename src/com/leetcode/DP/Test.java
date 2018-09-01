package com.leetcode.DP;

public class Test {
	public static void main(String[] args) {
		String s1="CVTE";
		StringBuffer s2 = new StringBuffer(s1);
		StringBuffer s3 = s2.reverse();
		System.out.println(s2==s3);
		System.out.println(s1.equals(s2)==true);
		System.out.println(s2.length());
	}
}
