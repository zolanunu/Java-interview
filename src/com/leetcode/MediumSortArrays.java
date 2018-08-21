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
	 * ���������������λ��
	 * */
	public double mediumSortedArrays(int[] a, int[] b) {
		
		int m = a.length, n = b.length;
		System.out.println("m="+m+"n=" +n);
		// �Ⱥϲ�����KСԪ��
		int[] c = merge(a, b);
		if((m+n)%2 == 0) { // ż��
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
		// �����������������ҵ���K�������
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
