package com.company;

import java.util.Scanner;

public class StringCode {
	/**
	 * 網易真题：字符串编码：从新构建字符串：出现次数+字符
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
