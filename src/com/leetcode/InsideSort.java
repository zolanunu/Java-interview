package com.leetcode;

public class InsideSort {
	
	public static int[] directInsertSort(int[] arr, int n) {
	/**
	 * ����˼��:
     * ��һ����¼���뵽������õ�������У��Ӷ��õ�һ���£���¼����1�������
     * �����Ƚ����еĵ�1����¼������һ������������У�Ȼ��ӵ�2����¼������в��룬ֱ��������������Ϊֹ��
	 * Ҫ�㣺�����ڱ�����Ϊ��ʱ�洢���ж�����߽�֮�á�
	 * ƽ��O(n^2),���O(n),�O(n^2);�ռ临�Ӷ�O(1);�ȶ�;��
	 * */
		for(int i = 1; i < n; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
	public static int[] shellSort(int[] arr) {
		/**
		 * �Ƚ����������е�����Ԫ�طֳɶ�������У�ʹ��ÿ�������е�Ԫ�ظ�����Խ���
		 * Ȼ��Ը��������зֱ����ֱ�Ӳ������򣬴��������������С��������򡱺�
		 * �ٶ�����Ԫ�ؽ���һ��ֱ�Ӳ�������
		 * */
		return  null;
	}
	public static void main(String[] args) {
		int a[] = {3, 1, 2, 5, 0};
		int n = a.length;
		a = directInsertSort(a, n);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
