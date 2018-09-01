package com.leetcode;

import java.util.Scanner;

public class PeekElementInTwoArray {
	/***
	 *  二维数字中求峰值
	 * 二维数组中的峰值： 该元素比上下左右的元素都大
	 * 二维数组：N*M 最边缘的值假设为负无穷大
	 * */
	// 优化一点求每一行（列）的最大值，再通过二分法找最大值列的峰值（具体方法可见一维数组求峰值），这种算法时间复杂度为O(logn)
	
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
			// 拿到每一行的最大值，求最大值所在列的峰值
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
		// 返回最大值的下标
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
		// 返回峰值的下标
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
