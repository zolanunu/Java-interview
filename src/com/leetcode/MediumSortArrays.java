/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class MediumSortArrays {
	/**
	 * 两个有序数组的中位数
	 * */
	public double mediumSortedArrays(int[] a, int[] b) {
		
		int m = a.length, n = b.length;
		System.out.println("m="+m+"n=" +n);
		// 先合并再找K小元素
		int[] c = merge(a, b);
		if((m+n)%2 == 0) { // 偶数
			System.out.println("even");
			int k = (m+n)/2;
			System.out.println(findK(c, k));
			return (findK(c, k) + findK(c, k+1)) / 2.0;
		} else {
			System.out.println("odd");
			int k = (m+n)/2 +1;
			return findK(c, k);
		}
		
	}
	
	public int findK(int[] c, int k) {
		// 在两个有序数组中找到第K大的数字
		if(k >= 1) {
			return c[k-1];
		}
		return -1;
	}
	
	public int[] merge(int[] a, int[] b) {
		int[] temp = new int[a.length+b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < a.length && j < b.length) {
			if(a[i] <= b[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = b[j++];
			}
		}
		
		while(i < a.length) {
			temp[k++] = a[i++];
		}
		while(j < b.length) {
			temp[k++] = b[j++];
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2};
		int[] b = {3, 4};
		MediumSortArrays m = new MediumSortArrays();
		double x = m.mediumSortedArrays(a, b);
		System.out.println(x);
	}
}
