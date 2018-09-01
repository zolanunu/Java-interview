/**
 * 
 */
package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class DengChaSequeence {
	public static String dengchaString(int[] nums) {
		
		if(nums.length == 2) {
			return "Possible";
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		int d = nums[1] - nums[0];
		for(int i = 2; i < nums.length; i++) {
			if(nums[i] - nums[i - 1] == d) {
				continue;
			} else {
				return "Impossible";
			}
		}
		return "Possible";
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		String im = dengchaString(nums);
		System.out.println(im);
	}
}
