/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class KDiffPairsInAnArray {
	public static int findPairs(int[] nums, int k) {
		if(nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		if(nums[0] + k > nums[nums.length-1]){
			return 0;
		}
		int count = 0;
		//boolean[] visited = new boolean[nums.length];
		//System.out.println(visited[0]);
		int keyindex = -1;
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println("i: " + i + ", "+"nums[i]: "+nums[i] +", "+ "nums[i]+k: " + (nums[i] + k));
			//System.out.println(nums[i] + k);
			int target = nums[i] + k;
			if(i == 0) {
				keyindex = binarySearch(nums, 1, target);
				System.out.println("keyindex:" + keyindex);
				if(keyindex != -1) {
					count++;
				}
			} else if(i != 0 && nums[i] != nums[i-1]) {
				keyindex = binarySearch(nums, i+1, target);
				System.out.println("keyindex:" + keyindex);
				if(keyindex != -1) {
					count++;
				}
			}
			
		}
		return count;
	}
	
	public static int binarySearch(int[] nums, int start, int target) {
		int left = start, right = nums.length - 1;
		
		//System.out.println(mid);
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if(nums[mid] < target) {
				left = mid + 1;
			} else {
				return left;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 4, 1, 5};
		int k = 2;
		int c = findPairs(nums, k);
		System.out.println(c);
	}
}
