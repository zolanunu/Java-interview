package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
	/**
	 * 可以从Moore投票算法中得到一些启�?
	 * 观察可知，数组中至多可能会有2个出现次数超�? �? n/3 �? 的众�?
	 * 记变量n1, n2为�?��?�众数； c1, c2为它们对应的出现次数
	 * 遍历数组，记当前数字为num
	 * 若num与n1或n2相同，则将其对应的出现次数加1
	 * 否则，若c1或c2�?0，则将其置为1，对应的候�?�众数置为num
	 * 否则，将c1与c2分别�?1
	 * �?后，再统计一次�?��?�众数在数组中出现的次数，若满足要求，则返回之�??
	 * */
	public static List<Integer> majorityElement(int[] nums) {
		return null;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,1,4};
		List<Integer> l = majorityElement(nums);
		System.out.println(Math.floor(4/3));
		for(Integer e : l) {
			System.out.println(e);
		}
		
	}
}
