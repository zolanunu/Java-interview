package com.java.leetcode.coding;
/**
 * an array of integers, return the indices of two numbers such that they add up a target
 * each input would have exactly one solution, and you may not use the same element twice.
 * */
public class TwoSum {
	/**
	 * problem: the array is sorted or not
	 * */
	public static int[] solution(int[] a, int target) {
		int temp = target;
		int[] re = new int[2];
		boolean flag = false;
		for(int i = 0; i < a.length; i++) {
			if(i == a.length - 1) {
				throw new IllegalArgumentException("no such solution");
			}
			int ai = temp - a[i];
			// System.out.println("i:" + i + ", ai: " + ai);
			int j;
			for(j = i + 1; j < a.length; j++) {
				if(a[j] == ai) {
					flag = true;
					// System.out.println(a[j] + "," + ai);
					break;
				}
			}
			if(flag == true) {
				re[0] = i;
				re[1] = j;
				return re;
				
			}
			
		}
		return null;
	}
	public static void main(String[] args) {
		int[] num = {3, 2, 4};
		int target = 6;
		int[] re = solution(num, target);
		for(int i = 0; i < re.length; i++) {
			System.out.println(re[i]);
		}
	}
	
}
