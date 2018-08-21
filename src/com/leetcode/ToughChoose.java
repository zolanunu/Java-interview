package com.java.leetcode.coding;

import java.util.Scanner;

public class ToughChoose {
	/**
	 * һ�����У�����2��3�Ĳ���
	 * ÿ�ζ�������һ������2����3��Ӱ�챻2�����Ĵ���������������е����ܱ�2�����Ĵ��������������ǽ����
	 * */
	public static int last(int x) {
		if(x <= 1) {
			return 0;
		}
		int z = 0;
		while(x % 2 == 0 && x >= 1) {
			x /= 2;
			z++;
		}
		return z;
	}
	
	public static int sugerNumber(int[] m, int n) {
		if(n <= 0) {
			return  0;
		}
		int r = 0;
		for(int i = 0; i < n; i++) {
			r += last(m[i]);
		}
		System.out.println(r);
		return r;
	}
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n = inScanner.nextInt();
		int[] num=new int[n];
		for(int i = 0; i<n;i++) {
			num[i]=inScanner.nextInt();
		}
		System.out.println(sugerNumber(num, n));
	}
	
}
