package com.java.leetcode.coding;

public class MoveZeroes {
	public static int[] moveZeroes(int[] nums) {
		int count = 0;
		int k = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				count++;
			} else {
				//int temp = nums[k];
				nums[k] = nums[i];
				k++;
			}
		}
		//System.out.println(count);
		for(int j = nums.length - count; j < nums.length; j++) {
			//System.out.print("j = " + j + " before: " + nums[j]);
			//int temp = nums[j];
			nums[j] = 0;
			//System.out.println("after: " + nums[j]);
		}
		return nums;
	}
	public static void main(String[] args) {
		int[] nums = {1, 8, 0, 5, 9, 0};
		moveZeroes(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
