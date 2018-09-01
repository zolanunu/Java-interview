package com.leetcode;

public class NumSubArrayProductLessThanK {
	public int numSubArrayProductLessThanK(int[] nums, int k) {
		int n = nums.length;
		if(k == 0) {
			return 0;
		}
		int start = 0;
		int val = 1;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			val *= nums[i];
			while(val >= k && start <= i) {
				val /= nums[start];
				start++;
			}
			ans += i - start + 1;
		}
		return ans;
	}
}
