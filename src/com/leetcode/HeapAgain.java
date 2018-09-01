package com.leetcode;

public class HeapAgain {
	// 堆的性质
	/**
	 * 大小堆
	 * */
	/**
	 * 建立堆（大小堆）
	 * 调整堆
	 * */
	
	public static void heapSort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return ;
		}
		buildMaxHeap(arr); // 建最小堆
		for(int i = arr.length - 1; i >= 1; i--) { // 从第一个叶子节点开始，交换数据，进行排序，交换以后马上向下调整
			exchangeE(arr, 0, i);
			maxHeap(arr, i, 0); // 调整堆
		}
	}
	
	
	public static void buildMaxHeap(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return ;
		}
		int half = arr.length / 2; // 找到第一个非叶子节点开始调整
		for(int i = half; i >= 0; i--) {
			maxHeap(arr, arr.length, i); // 建堆的时候调整堆，从元素的前一半开始调整
		}
	}
	
	// 调整堆
	
	public static void maxHeap(int[] arr, int size, int i) {
		int left = i*2+1; // 左孩子元素位置
		int right = i*2+2;
		int largest = i;
		if(left < size && arr[left] > arr[i]) {
			largest = left;
		}
		if(right < size && arr[right] > arr[largest]) {
			largest = right;
		}
		if(i != largest) {
			exchangeE(arr, i, largest);
			maxHeap(arr, size, largest); // 继续向下进行调整
		}
	}
	
	public static void exchangeE(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void heapSortMin(int[] arr) {
		if(arr==null || arr.length == 0) {
			return ;
		}
		buildMinHeap(arr);
		for(int i = arr.length - 1; i >= 0; i--) {
			exchangeE(arr, 0, i);
			minHeap(arr, i, 0);
		}
	}
	public static void buildMinHeap(int[] arr) {
		if(arr == null || arr.length == 0) {
			return ;
		}
		int half = arr.length / 2; // 一样，是从第一个非叶子节点进行调整
		for(int i = half; i >= 0; i--) {
			minHeap(arr, arr.length, i);
		}
	}
	
	public static void minHeap(int[] arr, int size, int i) {
		// 向下开始调整
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int minIndex = i;
		if(left < size && arr[left] < arr[i]) {
			minIndex = left;
		}
		if(right < size && arr[right] < arr[minIndex]) {
			minIndex = right;
		}
		if(i != minIndex) {
			exchangeE(arr, i, minIndex);
			minHeap(arr, size, minIndex);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 6, 7, 9, 10, 3, 8, 1, 4};
		heapSortMin(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
