/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class FindMaxSumOfSubArray {
	// 数组中最大和的连续子数组
	public static int find(int[] arr) {
		int sum = arr[0];
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(sum >= 0) {
				sum += arr[i];
			} else {
				sum = arr[i];
			}
			if(max < sum) {
				max = sum;
			}
		}
		return max;
	}
	
	public static int find1(int[] arr) {
		// 动态规划： max(dp[i]) = getMax(max(dp[i-1]) + a[i], a[i])
		if(arr==null||arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return arr[0];
		}
		int sum = arr[0];
		int temp = arr[0];
		for(int i = 1; i < arr.length; i++) {
			temp = Math.max(arr[i], temp+arr[i]);
			if(sum < temp) {
				sum = temp;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] array = {6,-3,-2,7,-15,1,2,2};
		System.out.println(find(array));
	}
}
