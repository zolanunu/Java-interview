package com.java.leetcode.coding;

public class NonDecreaseArray {
	public boolean checkPossibility(int[] array) {
		int time = 0;
		if(array.length == 1) {
			return true;
		}
		for(int i = 1; i < array.length; i++) {
			if (array[i] < array[i-1]) {
				time++;
			}
			if(time == 2) {
				return false;
			} else {
				if(i != 1 && i != array.length-1) {
					if(array[i-1] > array[i+1] && array[i] < array[i-2]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
