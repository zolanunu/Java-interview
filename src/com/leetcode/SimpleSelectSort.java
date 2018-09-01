package com.leetcode;

public class SimpleSelectSort {
	public static int selectMink(int[] a, int n, int i) {
		int k = i;
		for(int j = i + 1; j < n; j++) {
			if(a[k] > a[j]) {
				k = j;
			}
		}
		return k;
	}
	public static int[] simpleSelectSort(int[] a, int n) {
		int key, temp;
		for(int i = 0; i < n; i++) {
			key = selectMink(a, n, i);
			if(key != i) {
				temp = a[i];
				a[i] = a[key];
				a[key] = temp;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int[] a = {3,1,5,7,2,4,9,6};
		a = simpleSelectSort(a, a.length);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
