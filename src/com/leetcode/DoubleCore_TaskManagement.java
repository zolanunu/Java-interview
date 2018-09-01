package com.leetcode;

import java.util.Scanner;

/**
 * һ��˫��CPU���������ܹ�ͬʱ�Ĵ�������������n����֪��������������Ҫ����CPU����
 * ������֪CPU��ÿ����1����Դ���1kb��ÿ����ͬʱֻ�ܴ���һ������
 * n��������԰�������˳�����CPU���д���������Ҫ���һ��
 * ������CPU�������������������ʱ�����٣��������С��ʱ�䡣 
 * 
 * ���룺�������У���һ������n���ڶ���
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
