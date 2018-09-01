package com.leetcode;


public class ShellSort {
	/**
	 * ϣ������Ҳ��Ϊ����С�������򡱣������ԭ���ǣ��ֽ������������Ԫ�طֳɶ��������
	 * ʹ��ÿ�������е�Ԫ�ظ�����Խ��٣�Ȼ��Ը��������зֱ����ֱ�Ӳ�������
	 * �������������С��������򡱺�����ڶ�����Ԫ�ؽ���һ��ֱ�Ӳ�������
	 * ��ˣ�����Ҫ������Ծ�ָ�Ĳ��ԣ������ĳ�����������ļ�¼���һ��������
	 * �������ܱ�֤���������ڷֱ����ֱ�Ӳ��������õ��Ľ���ǻ�������
	 * �����Ǿֲ�����ϣ�������Ƕ�ֱ�Ӳ��������㷨���Ż��������� 
	 * ��ν�Ļ������򣬾���С�Ĺؼ��ֻ�����ǰ�棬��Ļ����ں��棬����С�Ļ������м�
	 * �����2,1,3,6,4,7,5,8,9,���Ϳ��Գ�Ϊ���������ˡ�
	 * �����1,5,9,3,7,8,2,4,6��������9�ڵ���λ��2�ڵ�������λ��̸���ϻ�������
	 * 
	 * ��ú�ƽ�����Ӷ� nlogn  ��� n^2
	 * **/
	public static int[] shellSort(int[] a) {
		int j = 0;
		int temp = 0;
		for(int increment = a.length / 2; increment > 0; increment /= 2) {
			System.out.println("increment: " + increment);
			for(int i = increment; i < a.length; i++) {
				temp = a[i];
				for(j = i - increment; j >= 0; j -= increment) {
					if(temp < a[j]) {
						a[j+increment] = a[j];
					} else {
						break;
					}
				}
				a[j+increment] = temp;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int[] a = {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
		a = shellSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
}
