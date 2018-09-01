/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zolanunu
 *
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// int i = 0, j = 0;
		for(int i = 0; i < nums.length - k - 1; i++) {
			for(int j = i + k; j < nums.length; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		// int i = 0, j = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(i > k) {
				set.remove(nums[i -k -1]);
				if(!set.add(nums[i])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsNearbyDuplicate3(int[] nums, int k) {
        // 输入条件判断
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // 如果没有对应的key添加进去
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            // 已经有对应的key-value对
            else {
                // 原来保存的值对应的下标，它一定小于现在的下标
                int value = map.get(nums[i]);
                if (i - value <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
	
	
}
