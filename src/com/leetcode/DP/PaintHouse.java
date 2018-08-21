package com.java.leetcode.dynamicprograme;

public class PaintHouse {
	/**
	 * һ������ֻ����������ɫ(������)��ˢ
	 * ÿ����ɫ����ÿ�����Ӷ��м�Ǯ
	 * Ҫ�󣺼�Ǯ��ͣ����ڵķ��Ӳ���ͬ��ɫ
	 * */
	public int minCost(int[][] cost) {
		if(cost.length == 0 || cost[0].length == 0 || cost == null) {
			return 0;
		}
		int housenumber = cost[0].length;
		int[][] dp = cost;
		for(int i = 2; i < housenumber; i++) {
			// �ӵڶ������ӿ�ʼ��������ĳ����ɫ��ˢ����ôǰһ������ֻ��������������ɫ
			// ��˾���֪����С����ɫ�ü�
			for(int j = 0; j < 3; j++) {
				dp[i][j] = dp[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
				// ����֪�������ǰ�����ú�ɫ��ʱ���ü���͵������
			}// ��һ��Ҳ����չ����д������ѭ��
		}
		return Math.min(dp[housenumber-1][0], Math.min(dp[housenumber-1][1], dp[housenumber-1][2]));
	}
}
