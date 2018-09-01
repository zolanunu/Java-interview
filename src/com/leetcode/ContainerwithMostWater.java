package com.leetcode;

public class ContainerwithMostWater {
	/**
	 * ����n���Ǹ�������a1, a2, ..., an��(i, ai) and (i, 0)
	 * �ֱ��������(i, ai)������(i, ai) and (i, 0)��ֱ�ߣ�����n����
	 * �ҳ�����ֱ�ߣ�ʹ������ֱ����x���γɵ������ܹ�ʢ����ˮ��
	 * */
	
	/**
	 * �������ʢˮ���
	 * ����������
	 * ʢˮ���Ķ��٣������������н϶̵�һ��������
	 * ���������н϶�һ�������ܳ���
	 * */
	/**
	 * �������������������γɵ����Ϊ��ʼ�����
	 * �ҳ��������н�С��һ����������һ��i++����
	 * ԭ�����ҳ�һ������ı��������С�ıߣ���ʹ�������������
	 * */
	public int maxArea(int[] height) {
		int maxArea = 0, left = 0;
		int right = height.length - 1;
		while(left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right++;
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		Object object = new Object();
		System.out.println("The class of " + object + "is " + object.getClass().getName());
	}
}
