package com.datastructure;

import java.util.Scanner;

public class PrintNumberBinary {
	// ��ӡ��������������ڵ�ʵ�ʱ�ʾ
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		for(int i = 0; i < 32; i++) {
			int t = (a&0x80000000>>>i)>>>(31-i);
			System.out.print(t);
		}
		System.out.println();
		// float��ʾ
		float b = -5;
		System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(b)));
		in.close();
	}
}
