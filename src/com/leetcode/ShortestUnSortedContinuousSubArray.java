/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class ShortestUnSortedContinuousSubArray {
	public static int findUnsortedSubarray(int[] nums) {
		int len = nums.length;
		int[] numscopy = new int[nums.length];
		for(int i = 0; i < len; i++) {
			numscopy[i] = nums[i];
		}
		Arrays.sort(nums);
		int s = -1, e = -1;
		for(int i = 0; i < len; i++) {
			if(numscopy[i] != nums[i]) {
				if(s == -1) {
					s = i;
				}
				e = i;
			}
			System.out.println(s +" "+ e);
		}
		if(s == e) {
			return 0;
		}
		System.out.println(s +" "+ e);
		return e - s + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,2};
		System.out.println(findUnsortedSubarray(nums));
	}
}
