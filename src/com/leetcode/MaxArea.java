/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class MaxArea {
	/**
	 * �����ڵ�ˮ�����
	 * */
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;
		while(left < right && left >= 0 && right <= height.length - 1) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if(height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return maxArea;
	}
}
