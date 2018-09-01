package com.leetcode;

public class FindPeekElement {
	/**
	 * leetcode 162: Find Peek Element
	 * 
	 *  һά�����еķ�ֵ����ֵ�����ھӴ��Ԫ�أ�
	 * */
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
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1 , 13, 2};
		int index = peekElement(arr);
		System.out.println(index + " " + arr[index]);
	}
}
