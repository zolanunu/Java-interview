/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class CountStar {
	/**
	 * IT牛客网模拟考场 六月
	 * 数星星
	 * */
	/**
	 * 时间复杂度太高了
	 * */
	public static int countStar(int[][] stars, int[][] a1, int[][] a2) {
		int len = stars.length;
		int count = 0;
		for(int i = 0; i < len; i++) {
			if(stars[i][0] >= a1[0][0] && stars[i][0] <= a2[0][0] && stars[i][1] >= a1[0][1] && stars[i][1] <= a2[0][1]) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int n = in.nextInt(); // 星星个数
		int[][] stars = new int[n][2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				stars[i][j] = in.nextInt();
			}
		}
		int m = in.nextInt(); // 问题个数
		int[][] a = new int[m][4];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < 4; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < m; i++) {
			// int[][] a1 = new int[1][2];
			int[][] a1 = new int[1][2];
			int[][] a2 = new int[1][2];
			a1[0][0] = a[i][0];
			a1[0][1] = a[i][1];
			a2[0][0] = a[i][2];
			a2[0][1] = a[i][3];
			System.out.println(countStar(stars, a1, a2));
		}
	}
}
