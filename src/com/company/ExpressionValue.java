package com.company;

import java.util.Scanner;

public class ExpressionValue {
	/**
	 *  给定三个数, + *操作，求最大值 
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int result = 0;
		result = a*b > a+b ? a*b:a+b;
		result =  result * c > result + c ? result * c : result + c;
		System.out.println(result);
		in.close();
	}
}
