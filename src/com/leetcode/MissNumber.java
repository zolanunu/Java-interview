package com.java.leetcode.coding;

import java.util.Arrays;

public class MissNumber {
	/**
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		// int len = nums.length;
		Arrays.sort(nums);
		if (nums.length == 1) {
			return nums[0] == 1 ? 0 : 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
		return nums.length;
	}
}
