package com.datastructure;

import java.util.Scanner;

public class MissNumberInSortArr {
	/**
	 * ��ָoffer ������53 ��Ŀ��
	 * �ڳ���Ϊn-1��������������0-n-1��0~n-1�����������н�����һ�Σ�ȱʧ������
	 * */
	public static void main(String[] args) {
		// ��һ�ֽⷨ���ǣ���ͣ�Ȼ���ֵΪ���������е�����
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i = 0; i < n-1; i++) {
			arr[i] = inScanner.nextInt();
			sum += arr[i];
		}
		int sumforALl = n*(n-1)/2;
		System.out.println(sumforALl-sum);
		inScanner.close();
		// ����Ľⷨ���Ƕ��ֲ��ң���Ϊ�������
		
	}
	
	public static int getMissNumber(int[] arr, int len) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		int left = 0;
		int right = len -1;
		while(left <= right) {
			int mid = (left+right)>>1;
			if(arr[mid]!=mid) {
				if(mid==0||arr[mid-1]==mid-1) {
					return mid;
				}
				right = mid - 1;
			} else {
				left = right + 1;
			}
		}
		if(left==right) {
			return len;
		}
		// ��Ч�����룬���鲻������ģ��������ֲ���0-n-1�ķ�Χ��
		return -1;
	}
}
