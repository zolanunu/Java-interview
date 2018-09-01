package com.leetcode;
public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int now = 0,  ans = 0;
		for(int i = 0; i < timeSeries.length; i++) {
			ans += Math.min(duration, timeSeries[i]+duration-now);
			now = timeSeries[i] + duration;
		}
		return ans;
	}
}
