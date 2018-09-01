package com.leetcode;

import java.util.Scanner;

public class NumberCompare {
	/**
	 * 
	 * 牛牛很喜欢对数字进行比较，但是对于3 > 2这种非常睿智的比较不感兴趣。
	 * 上了高中之后，学习了数字的幂，他十分喜欢这种数字表示方法，比如xy。
	 * 由此，他想出了一种十分奇妙的数字比较方法，给出两个数字x和y
	 * 请你比较xy和yx的大小，如果前者大于后者，输出">"，小于则输出"<"，等于则输出"="。
	 * 两个数字x和y。
	 * 满足1 <= x,y <= 109
	 * */
	/**
	 * 取对数的方式比较
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double suma = b * Math.log(a);
		double sumb = a * Math.log(b);
		
		if(suma>sumb) {
			System.out.println(">");
		} else if(suma<sumb) {
			System.out.println("<");
		} else {
			System.out.println("=");
		}
	}
	
	
}
