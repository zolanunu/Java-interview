package com.company;

import java.util.Scanner;

public class DontToChuCha {
	/**
	 * ���տ�����У԰��Ƹ��Ҫ��HRС�к�С����Ҫ�����������У��ֱ�ΪA��B��C���������Թ�ȥ����ͬ����
	 * ����HR�������¹涨��������һ����ѡ�����Թ٣�ÿ������ѡ��һλ������ѡ��ÿ���ʣ�����Թ���������ѡ�������Թٵ�HR��Ҫ�Լ����
	 * */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String inputString = sc.next().toString();
		String stringArray[] = inputString.split(",");
		int num[] = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			num[i] = Integer.parseInt(stringArray[i]);
		}
		int a = num[0];
		int b = num[1];
		int c = num[2];
		int bool = a ^ b ^ c;
		if (bool == 0)
			System.out.print(1);
		else {
			if ((a ^ b) < c) {
				System.out.print("C," + (c - (a ^ b)));
			}
			if ((a ^ c) < b) {
				System.out.print("B," + (b - (a ^ c)));
			}
			if ((b ^ c) < a) {
				System.out.print("A," + (a - (b ^ c)));
			}
		}
		sc.close();
	}
}
