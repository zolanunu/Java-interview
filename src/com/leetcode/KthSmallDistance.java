package com.leetcode;

import java.util.Arrays;

public class KthSmallDistance {
	public int kthSmallDistance(int[] nums, int k) {
		Arrays.sort(nums);
		int l = 0;
		int h = nums[nums.length-1] -nums[0];
		while(l < h) {
			int m = (l+h) / 2;
			// search
			//使用窗口思想，判断差值<=k的个数，r-l即表示[l,r]间间隔<m的个数（每确定一个窗口就新增加了（r-l+1）- 1个差值对）
			int left = 0;
			int count = 0;
			for(int right = 0; right < nums.length; right++) {
				while(nums[right] - nums[left] > m) {
					left++;
				}
				count += right - left;
			}
			if(count>=k) {
				h = m;
	        } else {
	        	 l = m+1;
	        }
		}
		return l;
	}
}
