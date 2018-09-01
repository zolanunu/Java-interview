package com.leetcode.DP;

public class HouseRobberII {
	/**
	 * ���з���Χ��Ȧ
	 * С͵ȥ���٣�Ҫ����Ǯ��࣬����������
	 * ����û�ҵĿ�͵��Ǯ
	 * �������ڼ�
	 * ������˵�һ�ң��Ͳ��������һ�ң�
	 * ��Ϊ��β�����ˣ����Ե�һ�Һ����һ��ֻ�������е�һ�ң����߶�����
	 * */
	
	public int rob(int[] nums) {
		if(nums.length <= 1) {
			return (nums == null || nums.length == 0) ? 0 : nums[0];
		}
		return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
		// ѡ���һ�������߲���
	}
	public int rob(int[] nums, int s, int e) {
		if(e - s <= 1) {
			return nums[s];
		}
		int[] dp = new int[e];
		dp[s] = nums[s];
		dp[s+1] = Math.max(nums[s], nums[s+1]); // ѡ���s������������s+1�ң��Ϳ��ļҵ�Ǯ����
		for(int i = s+2; i < e; i++) {
			dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]); // ֮��Ļ����Ϳ�ʼ��������ѡ��
			//
		}
		return dp[e];
	}
}
