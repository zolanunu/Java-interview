package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ThreeSumClosest {
	/**
	 * 三个数之和最近
	 * */
	public static int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		// List<List<Integer>> threeSumList = new ArrayList<List<Integer>>();
		int min = Integer.MAX_VALUE;
		int indexi=0,indexj=0,indexk=0;
		for(int i = 0; i < nums.length;i++) {
			for(int j = nums.length-1; j >= i && j - i >= 2; j--) {
				//List<Integer> list = new ArrayList<Integer>();
				int sumij = nums[i] + nums[j];
				System.out.println("i " + i + " j " + j + "sumij" + sumij);
				for(int k = i+1; k < j; k++) {
					if(min > Math.abs(target - (nums[k] + sumij))) {
						min = Math.abs(target - (nums[k] + sumij));
						indexi = i;
						indexj = j;
						indexk = k;
					}
					
				}
			}
		}
		System.out.println("indexi = " + indexi + " indexj = " + indexj + " indexk = " + indexk);
		return nums[indexi] + nums[indexj] + nums[indexk];
	}
	public static void main(String[] args) {
		int[] nums = {1,1,-1,-1,3};
		int target = -1;
		int sum = threeSumClosest(nums, target);
		System.out.println(sum);
		
	}
}
