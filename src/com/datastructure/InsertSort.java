package com.datastructure;

public class InsertSort {

	// 简单的插入排序算法
	public static void insertSort(int[] arr) {
		/**
		 * 插入排序：将未排序好的元素，插入到已经排序好的元素中，在插入过程中涉及对元素的移动操作 额外的空间：O（1） 稳定性：稳定的 使用情况：数据量小的
		 * 复杂度分析：O(n^2) O(n)
		 */
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int cur = arr[i]; // 待插入的元素
			while (j >= 0 && cur < arr[j]) {
				arr[j + 1] = arr[j]; // 元素后移
				j--;
			}
			arr[j + 1] = cur;
		}
	}

	// 改进版本的二分插入排序
	public static void insertSortByBinary(int[] arr) {
		/**
		 * 在找插入的位置的时候采用二分查找的方式
		 */

		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int left = 0;
			int right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] > cur) {
					right = mid - 1;
				} else if (arr[mid] <= cur) {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				arr[j + 1] = arr[j];
			}
			arr[left] = cur;
		}
	}

	// 希尔排序:插入排序的改进版本，是不稳定的排序
	// 插入排序对已经排好序的数据，效率会高一点
	public static void shellSort(int[] arr) {
		/**
		 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
		 * 按增量序列个数k，对序列进行k 趟排序； 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
		 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
		 */
		/**
		 * shell排序算法 增量h=(h*3)+1; 这个增量公式是由Knuth给出的 如果不是很了解的话请百度一下吧
		 * 
		 * @param arr
		 */
		// 首先根据数组的长度确定增量的最大值
		int h = 1;
		// 按h * 3 + 1得到增量序列的最大值
		while (h <= arr.length / 3)
			h = h * 3 + 1;
		// 进行增量查找和排序
		while (h >= 1) {
			for (int i = h; i < arr.length; i++) {
				for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
					int temp = arr[j];
					arr[j] = arr[j - h];
					arr[j - h] = temp;
				}
			}
			h = h / 3;
		}

	}
	// 选择排序
	/**
	 * 时间复杂度：O（n^2）
	 * 辅助空间:O(1)
	 * 不稳定
	 * */
	public static void selectSort(int[] arr) {
		// 找到最大或者最小的位置元素，和合适的位置交换
		if(arr==null||arr.length==0) {
			return ;
		}
		for(int i = 0; i < arr.length-1; i++) {
			int min = i;
			int j = i + 1;
			for(;j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			System.out.println(i+" " + min);
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	static int k = 2;
	static int f(int i) {
		
		k++;
		return i / k;
	}
	// 堆排序，冒泡排序
	public static void main(String[] args) {
		int[] arr = { 4, 2, 6, 1, 7, 9, 0, 2 };
		// insertSort(arr);
		//insertSortByBinary(arr);
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(f(f(f(1000))));
	}
}
