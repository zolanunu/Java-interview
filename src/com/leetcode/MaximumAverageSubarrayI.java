/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class MaximumAverageSubarrayI {
	public static double findMaxAverage(int[] nums, int k) {
		if(k > nums.length || nums.length == 0 || k <= 0) {
			return 0.0;
		}
		double maxAverage = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length-k+1; i++) {
			int sum = 0;
			//System.out.println(i + ", " + maxAverage);
			for(int j = i; j < i+k; j++) {
				sum = sum + nums[j];
			}
			//System.out.println(i + ", "+ sum);
			if(sum / (double)k > maxAverage) {
				maxAverage = sum / (double)k;
				
			}
		}
		return maxAverage;
	}
	public double findMaxAverage1(int[] nums, int k) {
		double sum = 0.0;
		for(int i =0; i < k; i++) {
			sum = sum + nums[i];
		}
		double res = sum;
		for(int i =k; i < nums.length; i++) {
			sum += nums[i] - nums[i -k];
			res = Math.max(res, sum);
		}
		return res/(double)k;
	}
	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
		double x = findMaxAverage(nums, 4);
		System.out.println(x);
	}
}
