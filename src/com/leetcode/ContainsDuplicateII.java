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
        // ���������ж�
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // ���û�ж�Ӧ��key��ӽ�ȥ
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            // �Ѿ��ж�Ӧ��key-value��
            else {
                // ԭ�������ֵ��Ӧ���±꣬��һ��С�����ڵ��±�
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
