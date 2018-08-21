package com.company;

import java.util.Scanner;

public class Takenapping {
	/**
	 * 高数课上睡觉
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] scores = new int[n];
		int[] isSleepy = new int[n];
		for(int i = 0; i < n; i++) {
			scores[i] = in.nextInt();
		}
		for(int i = 0; i < n; i++) {
			isSleepy[i] = in.nextInt();
		}
		
		int sum = 0;
		// 表示从左到右醒着的分值的累加和。
		int[] leftScore = new int[n];
		for(int i = 0; i < n; i++) {
			if(isSleepy[i] == 1) {
				sum+=scores[i];
			}
			leftScore[i] = sum;
		}
		// rightScore: 表示从右到左醒着的分值的累加和。
		int[] rightScore = new int[n];
		sum = 0;
		for(int i = n -1; i >= 0; i--) {
			if(isSleepy[i]==1) {
				sum+=scores[i];
			}
			rightScore[i] = sum;
		}
		// total: 表示从左到右分数的累加和。
		int[] total = new int[n];
		sum = 0;
		for(int i = 0; i < n; i++) {
			sum+=scores[i];
			total[i] = sum;
		}
		int max = -1;
		// 然后当我们遍历到为未醒着的位置i时
		// 那么这时的总体分数为3部分之和：leftScore[i-1] + rightScore[i+k] + (total[i+k-1] - total[i-1])。
		for(int i = 0; i < n; i++) {
			if(isSleepy[i] == 0) {
				int temp = 0;
				temp += (i-1) < 0 ? 0 : leftScore[i-1];
				temp += (i + k) >= n ? 0 : rightScore[i+k];
				temp += total[Math.min(i+k-1, n-1)] - (i-1<0?0:total[i-1]);
				if(temp > max) {
					max = temp;
				}
			}
		}
		System.out.println(max);
		in.close();
		

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		int[] scores = new int[n];
//		for (int i = 0; i < n; i++) {
//		scores[i] = sc.nextInt();
//		}
//		int[] sleep = new int[n];
//		for (int i = 0; i < n; i++) {
//		sleep[i] = sc.nextInt();
//		}
//		int sum = 0;
//		int max = -1;
//		for (int i = 0; i < n; i++) {
//		if (sleep[i] == 1) {
//		sum += scores[i];
//		}
//		}
//		for (int i = 0; i < n; i++) {
//		if (sleep[i] == 0) {
//		int temp = sum;
//		for (int j = i; j < Math.min(i + k, n); j++) {
//		if (sleep[j] == 0) {
//		temp += scores[j];
//		}
//		}
//		if (temp > max) {
//		max = temp;
//		}
//		}
//		}
//		System.out.println(max);
		
	}
}
