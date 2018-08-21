/**
 * 
 */
package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zolanunu
 *
 */
public class FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return null;
		}
		List<Integer> ret = new ArrayList<Integer>();
		for(int i = 0; i < len; i++) {
			int temp = Math.abs(nums[i]) - 1;
			if(nums[temp] < 0) {
				ret.add(temp+1);
			}
			nums[temp] = -nums[temp];
		}
		return ret;
	}
}
