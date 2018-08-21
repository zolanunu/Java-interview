package com.company;

import java.util.Scanner;

public class CountApple {
	/**
	 * 数苹果是哪一堆的
	 * 第一行一个数n(1 <= n <= 105)。
	 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
	 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
	 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] apples = new int[n];
		int[] sum = new int[n];
		int sumi = 0;
		for(int i = 0; i < n; i++) {
			apples[i] = in.nextInt();
			sumi+=apples[i];
			sum[i] = sumi;
		}
		int m = in.nextInt();
		int[] questions = new int[m];
		for(int i = 0; i < m; i++) {
			questions[i] = in.nextInt();
		}
		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				if(questions[i] <= sum[j]) {
//					System.out.println(j+1); // 这里可以使用二分查找
//					break;
//				}
//			}
			System.out.println(binarySearch(apples, questions[i]));
		}
		in.close();
	}
	
	public static int binarySearch(int[] arr, int target) {
		
		int mid = arr.length / 2;
		if(arr[mid] == target) {
			return mid;
		}
		int start = 0;
		int end = arr.length - 1;
		while(start<=end) {
			mid = (end-start)/2+start;
			if(target < arr[mid]) {
				end = mid - 1;
			} else if(target > arr[mid]){
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return start;
	}
	
	
}
