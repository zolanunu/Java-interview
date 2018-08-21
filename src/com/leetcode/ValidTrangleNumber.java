/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class ValidTrangleNumber {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int size = nums.length;
		int ans = 0;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				int k = binarySearch(nums, j + 1, nums[i] + nums[j]);
				ans += k - j - 1;
			}
		}
		return ans;
	}
	public int binarySearch(int[] nums, int start, int target) {
		int left = start, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] >= target) right = mid - 1;
			else left = mid + 1;
		}
		return left;
	}
	
	
}
