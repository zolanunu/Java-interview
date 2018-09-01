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
			//ʹ�ô���˼�룬�жϲ�ֵ<=k�ĸ�����r-l����ʾ[l,r]����<m�ĸ�����ÿȷ��һ�����ھ��������ˣ�r-l+1��- 1����ֵ�ԣ�
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
