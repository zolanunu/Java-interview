/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class MaxConsucutiveOnes {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int len = nums.length;
		if(len == 1 && nums[0] == 1) {
			return 1;
		}
		int count = 0;
		int maxCount = 0;
		int i = 0;
		while(i < len){
			if(nums[i] == 1) {
				count++;
			} else {
				//System.out.println("i = " + i);
				maxCount = Math.max(count, maxCount);
				//System.out.println("maxCount = " + maxCount);
				count = 0;
			}
			i++;
		}
		maxCount = Math.max(count, maxCount);
		return maxCount;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 0, 1, 1, 1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}
