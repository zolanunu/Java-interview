package com.leetcode;

public class PourWater {
	/**
	 * �ײ��߶ȷֲ���ͬ��ˮ���е�ˮ��������ˮ�۸߶ȷֲ�
	 * */
	/**
	 * ˼·�������ÿһ�����ˮ�������¹����������
	 * �����K�������ڵ��ƽϵ��ҿɴ��λ�ã���ˮ��������������
	 * ������K���Ҳ���ڵ��ƽϵ��ҿɴ��λ�ã���ˮ���Ҳ�������
	 * ����ˮͣ����K����
	 * */
	
	
	/**
	 * @Title: findLeftIndex 
	 * @Description: �ҵ���˵ĵʹ�
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
	 * @Description: TODO(������һ�仰�����������������)   
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
