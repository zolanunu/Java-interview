package com.company;

import java.util.Scanner;

public class StringCode {
	/**
	 * �W�����⣺�ַ������룺���¹����ַ��������ִ���+�ַ�
	 * */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.next();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(int i = 0; i < string.length();) {
			int j = i + 1;
			char string2 = string.charAt(i);
			while(j < string.length() && string.charAt(j)==string.charAt(i)) {
				j++;
				count++;
			}
			i = j;
			sb.append(count).append(string2);
			count = 1;
			System.out.println(i + " " + j + " " + count);
		}
		System.out.println(sb.toString());
		in.close();
	}
}
