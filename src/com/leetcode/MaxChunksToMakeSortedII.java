/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class MaxChunksToMakeSortedII {
	public int maxChunksToSorted(int[] arr) {
	     int len = arr.length;
			int ans = 1;
			for (int x = len-2; x >= 0; x--) {
				if(min(arr, x+1, arr.length-1) >= max(arr, 0, x)){
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
}
