package com.company;

import java.util.Scanner;

public class DontToChuCha {
	/**
	 * 按照卡中心校园招聘的要求，HR小招和小商需要从三个科室中（分别为A、B、C）抽派面试官去往不同城市
	 * 两名HR按照以下规定轮流从任一科室选择面试官：每次至少选择一位，至多选择该科室剩余面试官数。最先选不到面试官的HR需要自己出差。
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
