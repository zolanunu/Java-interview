package com.company;

import java.util.Scanner;

public class HouseGame {
	/**
	 * ���ף���������
	 * ����ٶȲ�ͬ����һ�����ɴ�С���С�������a1��a2��������an ��ôa1���κ�λ�ö����Դ�� a2������a1����ſ��Դ��
	 * ��Ϊ·�����޳������Ը�����1/2 a3ͬ����Ҫ��a1��a2������ܻ���ʾ���1/3 �Դ����ƣ�������: 1+1/2+1/3+��..+1/n
	 * */
	
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		double ans = 0;
		for(int i = 1; i <= n; i++) {
			ans += 1.0 / i;
		}
		System.out.println(ans);
		inScanner.close();
	}
}
