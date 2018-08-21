package com.java.leetcode.coding;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int left = 1;
		for(int i = 0; i < n; i++) {
			if(i > 0) {
				left = left * nums[i - 1];
			}
			res[i] = left;
		}
		int right = 1;
		for(int i = n - 1; i >= 0; i--) {
			res[i] = res[i] * right;
			right = right * nums[i];
			
		}
		//int product = 1;
		return res;
	}
}
