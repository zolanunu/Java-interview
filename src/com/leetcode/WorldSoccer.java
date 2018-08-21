/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class WorldSoccer {
	/**
	 * 世界杯买门票
	 * 
	 * */
	
	/**
	 * 动态规划
	 * */
	
	 final static int maxn = 1100;
	public static void main(String[] args) {
		int[][] dp = new int[maxn][maxn];
		int[] weight = new int[maxn]; // 存套餐价格
		int[] value = new int[maxn]; // 存套餐提供票数
		
		int n, m, k;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt(); // 人数
		m = in.nextInt(); // 套参数
		k = in.nextInt(); // 单张票价
		n = n + 1;
		for(int i = 1; i <= m; i++) {
			
			weight[i] = in.nextInt();
			value[i] = in.nextInt(); 
		}
		
//		for(int i = 1; i <= m; i++) {
//			System.out.print(weight[i]);
//			//System.out.println(value[i]);
//		}
//		System.out.println();
//		for(int i = 1; i <= m; i++) {
//			//System.out.print(weight[i]);
//			System.out.print(value[i]);
//		}
		for(int i = 1; i <= n; i++) {
			dp[0][i] = i * k;
			
			
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(j > value[i]) {// 当前人数大于套餐中提供的票数
					dp[i][j] = Math.min(dp[i-1][j],  dp[i-1][j-value[i]] + weight[i]);
					// 使用当前价格和不适用当前价格的比较
				} else {
					dp[i][j] = Math.min(dp[i-1][j], weight[i]); // 当人数小于等于套餐中的提供票数的时候，两种情况，不用和使用
				}
			}
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[m][n]);
	}
}
