package com.leetcode;

public class PourWater {
	/**
	 * 底部高度分布不同的水槽中倒水，求最后的水槽高度分布
	 * */
	/**
	 * 思路：倒入的每一体积的水按照如下规则进行流动
	 * 如果在K点左侧存在地势较低且可达的位置，则水优先向左流动。
	 * 否则，在K点右侧存在地势较低且可达的位置，则水向右侧流动。
	 * 否则，水停留在K处。
	 * */
	
	
	/**
	 * @Title: findLeftIndex 
	 * @Description: 找到左端的低处
	 * @param: 
	 * @return:
	 * @throws
	 */
	public int findLeftMinIndex(int[] heights, int k) {
		int minIndex = k, minHeight = heights[k];
		for(int i = k-1; i >= 0; i--) {
			if(heights[i] < minHeight) {
				minIndex = i;
				minHeight = heights[i];
			} else if(heights[i] > minHeight) {
				break;
			}
		}
		return minIndex;
	}
	
	/**
	 * @Title: findRightMinIndex   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	public int findRightMinIndex(int[] heights, int k) {
		// TODO Auto-generated method stub
		int minIndex = k, minHeight = heights[k];
		for(int i = k+1; i < heights.length; i++) {
			if(heights[i] < minHeight) {
				minIndex = i;
				minHeight = heights[i];
			} else if(heights[i] > minHeight) {
				break;
			}
		}
		return minIndex;
	}
	public int[] pourWater(int[] heights, int V, int K) {
		for(int i = 0; i < V; i++) {
			int leftMinIndex = findLeftMinIndex(heights, K);
			if(leftMinIndex < K) {
				heights[leftMinIndex]++;
			} else {
				int rightMinIndex = findRightMinIndex(heights, K);
				if(rightMinIndex > K) {
					heights[rightMinIndex]++;
				} else {
					heights[K]++;
				}
			}
		}
		return heights;
	}
}
