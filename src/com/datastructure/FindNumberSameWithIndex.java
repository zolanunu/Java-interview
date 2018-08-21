package com.datastructure;

import java.util.Scanner;

public class FindNumberSameWithIndex {
	/**
	 * 剑指offer：面试题53
	 * 在递增数组（数字不重复）中找数字和下标一直的数
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			if(arr[i] == i) {
				System.out.println(arr[i]);
			}
		}
		// 利用二分查找法解决
		
		int s = getNumSameWithIndex(arr, n);
		System.out.println(s);
		in.close();
	}
	public static int getNumSameWithIndex(int[] arr, int n) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		int left = 0;
		int right = n-1;
		while(left <= right) {
			int mid = left+((right-left)>>1);
			if(arr[mid] == mid) {
				return mid;
			} else if(arr[mid] > mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
