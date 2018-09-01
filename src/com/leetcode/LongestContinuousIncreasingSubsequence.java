package com.leetcode;


public class LongestContinuousIncreasingSubsequence {
	public static int findLengthOfLCIS(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int curlen = 0;
		for(int i = 0, k = 1; i < nums.length-1; i++) {
			if(nums[i] < nums[i+1]) {
				k++;
				curlen = Math.max(curlen, k);
			} else {
				k = 1;
			}
		}
		return curlen;
	}
	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		int len = findLengthOfLCIS(nums);
		System.out.println(len);
	}
}
