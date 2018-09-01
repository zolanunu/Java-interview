package com.leetcode;

import java.util.Scanner;

public class PeekElementInTwoArray {
	/***
	 *  ��ά���������ֵ
	 * ��ά�����еķ�ֵ�� ��Ԫ�ر��������ҵ�Ԫ�ض���
	 * ��ά���飺N*M ���Ե��ֵ����Ϊ�������
	 * */
	// �Ż�һ����ÿһ�У��У������ֵ����ͨ�����ַ������ֵ�еķ�ֵ�����巽���ɼ�һά�������ֵ���������㷨ʱ�临�Ӷ�ΪO(logn)
	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			// �õ�ÿһ�е����ֵ�������ֵ�����еķ�ֵ
			int index = maxEle(arr[i]);
//			System.out.print("index = " + index + " ");
			int[] arrForCloumn = new int[N];
			for(int j = 0; j < N; j++) {
//				System.out.print(j + "," + index + " ");
				arrForCloumn[j] = arr[j][index];
				
			}
			int indexPeek = peekElement(arrForCloumn);
			System.out.println(indexPeek + " " + index);
//			int index = peekElement(arr[i]);
//			System.out.println(index);
//			if(i == 0 && index == 0) {
//				if(arr[i][i] > arr[i+1][i] && arr[i][i] > arr[i][i+1]) {
//					System.out.println(i +" " + i);
//				} else {
//					continue;
//				}
//			} else if(i != N- 1 && index == 0) {
//				if(arr[i][index] > arr[i+1][index] && arr[i][index] > arr[i-1][index] && arr[i][index] > arr[i][index+1]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			} else if(i == N -1 && index == 0) {
//				if(arr[i][index] > arr[i-1][index] && arr[i][index] > arr[i][index+1]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			} else if(i == 0 && index == N - 1) {
//				if(arr[i][index] > arr[i][index-1] && arr[i][index] > arr[i+1][index]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			} else if(i == N -1 && index == N -1) {
//				if(arr[i][index] > arr[i-1][index] && arr[i][index] > arr[i][index-1]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			} else if (i == 0) {
//				if(arr[i][index] > arr[i+1][index] && arr[i][index] > arr[i][index-1] && arr[i][index] > arr[i][index+1]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			} else if(i == N -1) {
//				if(arr[i][index] > arr[i-1][index] && arr[i][index] > arr[i][index-1] && arr[i][index] > arr[i][index+1]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			} else {
//				if(arr[i][index] > arr[i+1][index] && arr[i][index] > arr[i][index-1] && arr[i][index] > arr[i][index+1] && arr[i][index] > arr[i-1][index]) {
//					System.out.println(i + " " + index);
//				} else {
//					continue;
//				}
//			}
		}
		in.close();
	}
	
	public static int maxEle(int[] arr) {
		// �������ֵ���±�
		int maxIndex=  0;
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static int peekElement(int[] arr) {
		// ���ط�ֵ���±�
		int low = 0;
		int high = arr.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			int mid2 = mid + 1;
			if(arr[mid] < arr[mid2]) {
				low = mid2;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
