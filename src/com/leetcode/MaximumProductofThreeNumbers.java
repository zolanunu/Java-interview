/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class MaximumProductofThreeNumbers {
	public int maximumProduct(int[] nums) {
		if(nums.length < 3) {
			return 0;
		}
		// 首先对数组进行排序
		Arrays.sort(nums);
		return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
