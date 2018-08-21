package com.java.leetcode.coding;


/**
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * */
public class SpecialSum {
	public static int specialSumSolution(int n, int sum) {
		sum += n;
		return sum;
	}
	public static void main(String[] args) {
		int sum = specialSumSolution(6, 0);
		System.out.println(sum);
	}
}
