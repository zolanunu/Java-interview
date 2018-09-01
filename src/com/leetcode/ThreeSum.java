package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		if(nums.length < 3 || nums == null) {
			return null;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		List<List<Integer>> threeSumList = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length;i++) {
			for(int j = nums.length-1; j >= i && j - i >= 2; j--) {
				List<Integer> list = new ArrayList<Integer>();
				int sumij = nums[i] + nums[j];
				System.out.println("i " + i + " j " + j + "sumij" + sumij);
				for(int k = i+1; k < j; k++) {
					if(nums[k] == 0-sumij) {
						list.add(nums[k]);
						list.add(nums[i]);
						list.add(nums[j]);
						if(!threeSumList.contains(list)) {
							threeSumList.add(list);
						}
						break;
					}
				}
			}
		}
		return threeSumList;
	}
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = threeSum(nums);
		for(List<Integer> itemIntegers : list) {
			for(Integer item : itemIntegers) {
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}
}
