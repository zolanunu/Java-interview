package com.java.leetcode.dynamicprograme;

public class TwoKeysKeyboard {
	/**
	 * 只有复制和粘贴这两个操作，原始只有一个字母A，问最少经过过少步，能得到n个A
	 * 输入：n
	 * 输出：最少操作数
	 * */
	/**
	 * 下面是不用记录每一个中间值的解法
	 * */
	public static int minSteps(int n) {
		int res = 0;
		for(int i= 2;i <=n; i++) {
			while(n%i==0) {
				res+=i;
				n/=i;
			}
		}
		return res;
	}
	/**
	 * 下面是动态规划的解法
	 * */
	public static int minStepII(int n) {
		if(n==1) {
			return 0;
		}
		int[] dp = new int[n+1];
		for(int i = 2; i <= n; i++) {
			dp[i] = i;
			for(int j = i - 1; j > 1; j--) {
				if(i % j == 0) {
					dp[i] = Math.min(dp[i], dp[j]+i/j);
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(minSteps(5));
	}
}
