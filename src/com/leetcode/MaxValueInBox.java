package com.java.leetcode.coding;

import java.util.ArrayList;

public class MaxValueInBox {
	/**
	 * 滑动窗口的中的最大值
	 * */
	
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(size <= 0) {
			return list;
		}
		if(size > num.length) {
			return list;
		}
		for(int i = 0; i < num.length - size+1; i++) {
			maxValue(num, i, i+size, list);
		}
		return list;
	}
	
	public void maxValue(int[] arr, int s, int e, ArrayList<Integer> list){
		int maxV = Integer.MIN_VALUE;
		for(int i = s; i < e; i++) {
			if(arr[i] > maxV) {
				maxV = arr[i];
			}
		}
		list.add(maxV);
	}
}
