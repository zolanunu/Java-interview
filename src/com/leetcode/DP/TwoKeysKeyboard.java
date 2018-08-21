package com.java.leetcode.dynamicprograme;

public class TwoKeysKeyboard {
	/**
	 * ֻ�и��ƺ�ճ��������������ԭʼֻ��һ����ĸA�������پ������ٲ����ܵõ�n��A
	 * ���룺n
	 * ��������ٲ�����
	 * */
	/**
	 * �����ǲ��ü�¼ÿһ���м�ֵ�Ľⷨ
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
	 * �����Ƕ�̬�滮�Ľⷨ
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
