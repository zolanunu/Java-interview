package com.leetcode.DP;

public class HouseRobberII {
	/**
	 * 所有房子围成圈
	 * 小偷去抢劫，要求抢钱最多，不发出警报
	 * 给出没家的可偷的钱
	 * 不能抢邻家
	 * 如果抢了第一家，就不能抢最后一家，
	 * 因为首尾相连了，所以第一家和最后一家只能抢其中的一家，或者都不抢
	 * */
	
	public int rob(int[] nums) {
		if(nums.length <= 1) {
			return (nums == null || nums.length == 0) ? 0 : nums[0];
		}
		return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
		// 选择第一家抢或者不抢
	}
	public int rob(int[] nums, int s, int e) {
		if(e - s <= 1) {
			return nums[s];
		}
		int[] dp = new int[e];
		dp[s] = nums[s];
		dp[s+1] = Math.max(nums[s], nums[s+1]); // 选择第s家抢或者抢第s+1家，就看哪家的钱多了
		for(int i = s+2; i < e; i++) {
			dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]); // 之后的话，就开始抢或不抢的选择
			//
		}
		return dp[e];
	}
}
