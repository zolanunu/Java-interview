package com.java.leetcode.coding;

public class FindPivotIndex {
	public int sum(int[] a, int s, int e) {
		int si = 0;
		for (int i = s; i <= e; i++) {
			si += a[i];
		}
		return si;
	}
	public int findIndex(int[] nums) {
		if(nums.length < 3) {
			return -1;
		}
		int mid = nums.length / 2;
		while(mid > 0 || mid < nums.length - 1) {
			int sum1 = sum(nums, 0, mid-1);
			int sum2 = sum(nums, mid+1, nums.length-1);
			if(sum1 == sum2) {
				return mid;
			} else if(sum1 > sum2) {
				mid = mid - 1;
			} else {
				mid = mid + 1; //这样子不行，会出现死循环
			}
		}
		return -1;
	}
	public int findPivotIndex(int[] nums) {
		if(nums.length < 3) {
			return -1;
		}
		int[] sum = new int[nums.length];
		int max;
		for(int i = 0; i < nums.length; i++) {
			if(i == 0) {
				sum[i] = nums[i];
			} else {
				sum[i] = sum[i-1] + nums[i];
			}
		}
		max = sum[nums.length-1];
		for(int i = 0; i < nums.length; i++) {
			if(max - sum[i] == sum[i] - nums[i]) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(nums[0]);
	}
}
