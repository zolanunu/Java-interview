package com.leetcode;

public class DuplicateIntegerInArray {
	public static boolean duplicate(int[] a, int length, int[] duplication) {
		if(a == null) {
			return false;
		}
		if(length != a.length) {
			return false;
		}
		StringBuilder sBuilder = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sBuilder.append("#").append(a[i]).append("#");
		}
		String string = sBuilder.toString();
		System.out.println(string);
		for(int i = 0; i < length; i++) {
			if(string.indexOf("#"+a[i]+"#") != string.lastIndexOf("#"+a[i]+"#")) {
				duplication[0] = a[i];
				System.out.println(duplication[0]);
				return true;
			}
		}
		return false;
	}
	
	public static boolean duplicate1(int[] a, int n, int[] dup) {
		if(a == null || n <= 1) {
			return false;
		}
		for(int i = 0; i < n; i++) {
			if(a[i] < 0 || a[i] >= n) {
				return false;
			}
		}
		for(int i = 0; i < n; i++) {
			while(a[i] != i) {
				if(a[i] == a[a[i]]) {
					dup[0] = a[i];
					return true;
				}
			}
			int temp = a[i];
			a[i] = a[a[i]];
			a[a[i]] = temp;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] b = new int[1];
		int[] a = {2, 1, 0, 3, 2};
		int length = a.length;
		if(duplicate(a, length, b)) {
			System.out.println(b[0]);
		}
		int[] aui = {2,3,1,0,2,5,3};
		int[] dop = new int[1];
		int n = aui.length;
		System.out.println(n);
		if(duplicate1(aui, n, dop)) {
			System.out.println(dop[0]);
		}
	}
}
