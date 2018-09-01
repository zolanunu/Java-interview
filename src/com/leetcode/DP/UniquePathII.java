package com.leetcode.DP;

public class UniquePathII {
	/**
	 * 在迷宫探寻出口，有障碍物，求可行的不同路径数
	 * */
	
	public static int uniquePathWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else if(i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if(i == 0 && j > 0) {
					dp[i][j] = dp[i][j-1];
				} else if(i > 0 && j == 0) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		return dp[n-1][m-1];
	}
	
	public static int uniquePathWithObstaclesII(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		//int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[] dp = new int[m];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//System.out.print(dp[i][j]);
				if(obstacleGrid[i][j]==1) {
					dp[j] = 0;
				} else if(j>0) {
					dp[j] += dp[j-1];
				}
			}
			//System.out.println();
		}
		return dp[m-1];
	}
	public static void main(String[] args) {
		int[][] map = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathWithObstacles(map));
	}
}
