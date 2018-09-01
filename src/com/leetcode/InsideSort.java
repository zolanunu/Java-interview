package com.leetcode;

public class InsideSort {
	
	public static int[] directInsertSort(int[] arr, int n) {
	/**
	 * 基本思想:
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
     * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
	 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
	 * 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
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
		 * 先将待排序序列的数组元素分成多个子序列，使得每个子序列的元素个数相对较少
		 * 然后对各个子序列分别进行直接插入排序，待整个待排序序列“基本有序”后
		 * 再对所有元素进行一次直接插入排序。
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
