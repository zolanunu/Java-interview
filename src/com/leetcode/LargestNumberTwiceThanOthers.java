/**
 * 
 */
package com.leetcode;

/**
 * @author Skygazer
 *
 */
public class LargestNumberTwiceThanOthers {
	public int domainantIndex(int[] nums) {
		int maxIndex = max(nums);
		System.out.println(maxIndex);
		for(int i = 0; i < nums.length; i++) {
			if(i != maxIndex) {
				if(nums[i] * 2 > nums[maxIndex]) {
					return -1;
				}
			} else {
				continue;
			}
		}
		return maxIndex;
	}
	/**
	 * 思路一： 蛮力法，找到最大元素以后，再一一比对是否满足条件
	 * 思路二： 排序后，如果最大元素能大于或者等于第二大的元素的两倍，则满足条件。
	 * */
	public int max(int[] nums) {
		int maxIndex = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	public static void main(String[] args) {
		LargestNumberTwiceThanOthers l = new LargestNumberTwiceThanOthers();
		int[] nums = {0,0,0,1};
		int i = l.domainantIndex(nums);
		System.out.println(i);
	}
}
