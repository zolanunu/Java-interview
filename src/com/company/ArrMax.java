package com.company;

import java.util.Scanner;

public class ArrMax {
	/**
	 * ����һ���������У���ҪҪ��ѡ��һ�����䣬ʹ�ø����������������о���һЩ�����Ժ�����һ��
	 * */
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int[] arr = new int[n];
//		int max = Integer.MIN_VALUE;
//		int min = Integer.MAX_VALUE;
//		int sum = 0;
//		for(int i = 0; i < n; i++) {
//			arr[i] = in.nextInt();
//			if(max < arr[i] * arr[i]) {
//				max = arr[i] * arr[i];
//			}
//			if(arr[i] < min) {
//				min = arr[i];
//			}
//			sum += arr[i];
//		}
//		if(max < sum * min) {
//			max = sum * min;
//		}
//		// ����Ϊn-1��n-2,...,2
//		for(int i = 0; i < n; i++) {
//			int[] ar = new int[2];
//			for(int j=2; i!=j&&j<n; j++) {
//				ar = min(arr, i, i+j-1);
//			}
//			if(max < ar[0]*ar[1]) {
//				max = ar[0]*ar[1];
//			}
//		}
//		
//		System.out.println(max);
//		in.close();
		// ��ʵ����ά��������������ʱ��Сֵ����ʱ����ͣ����ֵ���ϴ���.
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		int[] arr = new int[n];
		int min_num, sum;
		int max_sum = -1;
		for(int i = 0; i < n; i++) {
			arr[i] = inScanner.nextInt();
		}
		for(int i = 0; i < n; i++) {
			sum = arr[i];
			min_num = arr[i];
			max_sum = Math.max(sum*min_num, max_sum);
			for(int j = i + 1; j <n; j++) {
				sum += arr[j];
				min_num = Math.min(arr[j], min_num);
				max_sum = Math.max(sum*min_num, max_sum);
			}
		}
		System.out.println(max_sum);
		inScanner.close();
	}
	
	public static int[] min(int[] arr, int s, int e) {
		
		int[] ar = new int[2];
		//ar[0] = arr[0];
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = s; i <= e; i++) {
			sum += arr[i];
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		ar[0] = min;
		ar[1] = sum;
		return ar;
	}
}
