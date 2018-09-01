/**
 * 
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zolanunu
 *
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		if(nums.length == 1 || nums == null) {
			return false;
		}
		for(int i = 0; i < nums.length; i++) {
			if(!set.contains(nums[i])) {
				set.add(nums[i]);
			} else {
				return true;
			}
		}
		return false;
	}
}
