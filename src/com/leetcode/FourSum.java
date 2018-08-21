/**
 * 
 */
package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author zolanunu
 *
 */
public class FourSum {
	/**
	 * leetcode 18 ： 4sum
	 * 据说是(O(n2logn))
	 * */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 4) {
			return list;
		}
		Arrays.sort(nums);
		HashMap<Integer, List<Integer[]>> map = new HashMap<>();
		int n = nums.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				int sum = nums[i] + nums[j];
				Integer[] pairs = {i, j}; // 求出两两之和，并把sum和两个数的坐标对应起来
				if(!map.containsKey(sum)) {
					map.put(sum, new ArrayList<Integer[]>()); // 如果这个sum在map中没有，则初始化
				}
				map.get(sum).add(pairs);
				// System.out.println("sum = " + sum + "i = " + i + "j = " + j);
			}
		}// 到此，两两之和和其对应位置都映射好了
		Set<Integer> keys = map.keySet();
		for(int key : keys) {
			List<Integer[]> listA = map.get(key);
			List<Integer[]> listB = map.get(target- key);
			if(listA != null && listB != null) {
				for(Integer[] pairA : listA) {
					int a0 = pairA[0], a1 = pairA[1];
					for(Integer[] pairB : listB) {
						
						int b0 = pairB[0], b1 = pairB[1];
						// System.out.println("pairA = " + pairA[0] + "," + pairA[1] + "pairB = " + pairB[0] + "," + pairB[1]);
						if(a1 < b0) {
							List<Integer> list2 = new ArrayList<>();
							list2.add(nums[a0]);
							list2.add(nums[a1]);
							list2.add(nums[b0]);
							list2.add(nums[b1]);
							if(!list.contains(list2)) {
								list.add(list2);
							}
						}
					}
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[] nums = {-5,5,4,-3,0,0,4,-2};
		int target  = 4;
		List<List<Integer>> list = fourSum(nums, target);
		for(List<Integer> list2 : list) {
			for(int item : list2) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
