package com.java.leetcode.coding;

public class MaxiLengthSubArray {
	public static int[][] findLength(int[] A, int[] B) {
		int lenA = A.length, lenB = B.length;
		int max = 0;
		int[][] dp = new int[lenA+1][lenB+1];
		for(int i = 1; i <= lenA; i++) {
			for(int j = 1; j <= lenB; j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
					max = dp[i][j] > max ? dp[i][j] : max;
				}
			}
		}
		return dp;
	}
	public static void main(String[] args) {
		int[] A = {3, 1, 2};
		int[] B = {1, 2, 3};
		int[][] dp = findLength(A, B);
		for(int i = 0; i <= A.length; i++) {
			for(int j = 0; j <= B.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
