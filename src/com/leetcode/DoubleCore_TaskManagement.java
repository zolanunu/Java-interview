package com.leetcode;

import java.util.Scanner;

/**
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务
 * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个
 * 方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。 
 * 
 * 输入：包括两行，第一行整数n，第二行
 * */
public class DoubleCore_TaskManagement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		int arr[] = new int[n];
		int dp[] = new int[20000];
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			arr[i] = arr[i] / 1024;
			sum = sum + arr[i];
		}
		for(int i = 0; i < n; i++) {
			for(int j = sum/2; j >= arr[i]; --j) {
				dp[j] = Math.max(dp[j],dp[j-arr[i]]+arr[i]);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = sum/2; j >= arr[i]; --j) {
				System.out.print(dp[j] + " ");
			}
			System.out.println();
		}
		System.out.println((sum-dp[sum/2])*1024);
		in.close();
	}
}
