package com.java.leetcode.coding;


/**
 * ��Ŀ��������1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C��
 * */
public class SpecialSum {
	public static int specialSumSolution(int n, int sum) {
		sum += n;
		return sum;
	}
	public static void main(String[] args) {
		int sum = specialSumSolution(6, 0);
		System.out.println(sum);
	}
}
