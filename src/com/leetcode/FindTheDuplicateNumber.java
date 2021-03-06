package com.leetcode;
import java.util.Arrays;

public class FindTheDuplicateNumber {
	public int findDuplicateNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1]) {
				return nums[i];
			}
		}
		return 0;
	}
}
