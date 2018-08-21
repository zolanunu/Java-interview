package com.java.leetcode.dynamicprograme;

public class FourKeysKeyboard {
	public int maximumA(int n) {
		if(n <= 4) {
			return n;
		}
		int[] dp = new int[n+1];
		for(int i = 0; i <= n; i++) {
			dp[i] = i;
			for(int j = 0; j <= i - 3; j++) {
				dp[i] = Math.max(dp[i], dp[j]*(i-j-2+1)); // ¿ÉÄÜ»á·­±¶
			}
		}
		return dp[n];
	}
}
