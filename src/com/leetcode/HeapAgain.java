package com.leetcode;

public class HeapAgain {
	// �ѵ�����
	/**
	 * ��С��
	 * */
	/**
	 * �����ѣ���С�ѣ�
	 * ������
	 * */
	
	public static void heapSort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return ;
		}
		buildMaxHeap(arr); // ����С��
		for(int i = arr.length - 1; i >= 1; i--) { // �ӵ�һ��Ҷ�ӽڵ㿪ʼ���������ݣ��������򣬽����Ժ��������µ���
			exchangeE(arr, 0, i);
			maxHeap(arr, i, 0); // ������
		}
	}
	
	
	public static void buildMaxHeap(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return ;
		}
		int half = arr.length / 2; // �ҵ���һ����Ҷ�ӽڵ㿪ʼ����
		for(int i = half; i >= 0; i--) {
			maxHeap(arr, arr.length, i); // ���ѵ�ʱ������ѣ���Ԫ�ص�ǰһ�뿪ʼ����
		}
	}
	
	// ������
	
	public static void maxHeap(int[] arr, int size, int i) {
		int left = i*2+1; // ����Ԫ��λ��
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
			maxHeap(arr, size, largest); // �������½��е���
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
		int half = arr.length / 2; // һ�����Ǵӵ�һ����Ҷ�ӽڵ���е���
		for(int i = half; i >= 0; i--) {
			minHeap(arr, arr.length, i);
		}
	}
	
	public static void minHeap(int[] arr, int size, int i) {
		// ���¿�ʼ����
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
