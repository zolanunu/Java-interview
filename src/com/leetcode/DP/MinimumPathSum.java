package com.java.leetcode.dynamicprograme;

public class MinimumPathSum {
	/**
	 * m*n 路径上和最小
	 * */
	public static int minPathSum(int[][] grid) {
		if(grid==null||grid.length==0||grid[0].length==0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length;
		int[][] dp = grid;
		//dp[0][0] = grid[0][0];
		for(int j = 1; j < n; j++) {
			dp[0][j] += grid[0][j-1];
			System.out.println(dp[0][j]);
		}
		for(int j = 1; j < m; j++) {
			dp[j][0] += grid[j-1][0];
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				//dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int re = minPathSum(grid);
		
		System.out.println(re);
	}
}
