package com.leetcode;

public class FindPeekElement {
	/**
	 * leetcode 162: Find Peek Element
	 * 
	 *  一维数组中的峰值（峰值：比邻居大的元素）
	 * */
	public static int peekElement(int[] arr) {
		// 返回峰值的下标
		int low = 0;
		int high = arr.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			int mid2 = mid + 1;
			if(arr[mid] < arr[mid2]) {
				low = mid2;
			} else {
				high = mid;
			}
		}
		return low;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1 , 13, 2};
		int index = peekElement(arr);
		System.out.println(index + " " + arr[index]);
	}
}
