package com.leetcode;

public class MaxChunksToMakeSorted {
	// 769.Max Chunks To Make Sorted
	// 将arr数组拆分若干部分，使得每一部分分别排序以后，重新组合在一起的数组递增有序
	// 求最多能分成多少个部分
	// 贪心算法
	
	public int maxChunksToMakeSorted(int[] arr) {
		
		int len = arr.length;
		int ans = 1;
		for (int x = len-2; x >= 0; x--) {
			if(min(arr, x+1, arr.length-1) > max(arr, 0, x)){
				ans++;
			}
		}
		return ans;
	}
	public int min(int[] arr, int s, int e) {
		if(s == e) {
			return arr[s];
		}
		int min = arr[s];
		for(int i = s+1; i <= e; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	public int max(int[] arr, int s, int e) {
		if(s == e) {
			return arr[s];
		}
		int max = arr[s];
		for(int i = s+1; i <= e; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {1,0,2,3,4};
		MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();
		int ans = maxChunksToMakeSorted.maxChunksToMakeSorted(arr);
		System.out.println(ans);
		
	}
}
