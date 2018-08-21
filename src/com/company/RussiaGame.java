package com.company;

import java.util.Scanner;

public class RussiaGame {
	/**
	 * 俄罗斯方块：1*1的方块 计算分数
	 */

	public static int cou(int m, int[] num) {
		int s = 0;
		for (int i = 0; i < m; i++) {
			if (num[i] != 0) {
				s = s + 1;
			}
		}
		return s;
	}

	// 计算分数
	public static void countScore(int n, int m, int[] num) {
		int score = 0;
		do {
			int count = 1;
			for (int i = 0; i < m; i++) {
				if (num[i] == count && count <= (n + 1)) {
					count = count + 1;
					num[i] = 0;
				}
			}
			if (count - 1 == n) {
				score += (count - 1) / n;
			}

		} while (cou(m, num) >= n);

		System.out.println(score);

	}
	public static int score(int[] nums, int n) {
		int[] record = new int[n];
		for(int i = 0; i < nums.length; i++) {
			record[nums[i]] += 1;
		}
		int min = record[0];
		for(int i = 1; i < n; i++) {
			if(record[i]!=0 && min < record[i]) {
				min = record[i];
			}
		}
		System.out.println(min);
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
//		String s = sc.nextLine();
		String inputString = sc.nextLine();
		String stringArray[] = inputString.split(" ");
		int num[] = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = Integer.parseInt(stringArray[i]);
		}
		//countScore(n, m, num);
		System.out.println(score(num, n));
		sc.close();
	}
}
