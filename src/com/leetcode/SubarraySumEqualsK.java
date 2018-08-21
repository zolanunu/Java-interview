/**
 * 
 */
package com.java.leetcode.coding;


/**
 * @author zolanunu
 *
 */
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		if(nums.length == 0) {
			return 0;
		}
		//int num = 0;
		int se = nums.length, cnt = 0;
		int[] sum = new int[se+1];
		for(int i = 0; i < se; i++) {
			sum[i+1] = sum[i] + nums[i];
		}
		for(int i = 0; i < se; i++) {
			for(int j = i + 1; j <= se; j++) {
				if(sum[j] - sum[i] == k) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
