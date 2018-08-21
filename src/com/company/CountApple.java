package com.company;

import java.util.Scanner;

public class CountApple {
	/**
	 * ��ƻ������һ�ѵ�
	 * ��һ��һ����n(1 <= n <= 105)��
	 * �ڶ���n����ai(1 <= ai <= 1000)����ʾ������������i���ж���ƻ��
	 * ������һ����m(1 <= m <= 105)����ʾ��m��ѯ�ʡ�
	 * ������m����qi����ʾС��ϣ��֪����qi��ƻ��������һ�ѡ�
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] apples = new int[n];
		int[] sum = new int[n];
		int sumi = 0;
		for(int i = 0; i < n; i++) {
			apples[i] = in.nextInt();
			sumi+=apples[i];
			sum[i] = sumi;
		}
		int m = in.nextInt();
		int[] questions = new int[m];
		for(int i = 0; i < m; i++) {
			questions[i] = in.nextInt();
		}
		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				if(questions[i] <= sum[j]) {
//					System.out.println(j+1); // �������ʹ�ö��ֲ���
//					break;
//				}
//			}
			System.out.println(binarySearch(apples, questions[i]));
		}
		in.close();
	}
	
	public static int binarySearch(int[] arr, int target) {
		
		int mid = arr.length / 2;
		if(arr[mid] == target) {
			return mid;
		}
		int start = 0;
		int end = arr.length - 1;
		while(start<=end) {
			mid = (end-start)/2+start;
			if(target < arr[mid]) {
				end = mid - 1;
			} else if(target > arr[mid]){
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return start;
	}
	
	
}
