package com.datastructure;

import java.util.Scanner;

public class MissNumberInSortArr {
	/**
	 * 剑指offer 面试题53 题目二
	 * 在长度为n-1的有序数组中找0-n-1（0~n-1出现在数组中仅出现一次）缺失的数字
	 * */
	public static void main(String[] args) {
		// 第一种解法就是：求和，然后差值为不在数组中的数字
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i = 0; i < n-1; i++) {
			arr[i] = inScanner.nextInt();
			sum += arr[i];
		}
		int sumforALl = n*(n-1)/2;
		System.out.println(sumforALl-sum);
		inScanner.close();
		// 另外的解法就是二分查找，因为是有序的
		
	}
	
	public static int getMissNumber(int[] arr, int len) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		int left = 0;
		int right = len -1;
		while(left <= right) {
			int mid = (left+right)>>1;
			if(arr[mid]!=mid) {
				if(mid==0||arr[mid-1]==mid-1) {
					return mid;
				}
				right = mid - 1;
			} else {
				left = right + 1;
			}
		}
		if(left==right) {
			return len;
		}
		// 无效的输入，数组不是排序的，或者数字不在0-n-1的范围内
		return -1;
	}
}
