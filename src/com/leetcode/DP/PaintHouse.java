package com.java.leetcode.dynamicprograme;

public class PaintHouse {
	/**
	 * 一所房子只能用三种颜色(红绿蓝)来刷
	 * 每种颜色对于每栋房子都有价钱
	 * 要求：价钱最低，相邻的房子不能同颜色
	 * */
	public int minCost(int[][] cost) {
		if(cost.length == 0 || cost[0].length == 0 || cost == null) {
			return 0;
		}
		int housenumber = cost[0].length;
		int[][] dp = cost;
		for(int i = 2; i < housenumber; i++) {
			// 从第二栋房子开始，假设用某种颜色来刷，那么前一栋房子只能用另外两个颜色
			// 如此就能知道最小的颜色用价
			for(int j = 0; j < 3; j++) {
				dp[i][j] = dp[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
				// 就能知道如果当前房子用红色的时候用价最低的情况了
			}// 这一步也可以展开来写，不用循环
		}
		return Math.min(dp[housenumber-1][0], Math.min(dp[housenumber-1][1], dp[housenumber-1][2]));
	}
}
