package com.company;

import java.util.Scanner;

public class HouseGame {
	/**
	 * 网易：赛马问题
	 * 马的速度不同，则一定能由大到小排列。假设是a1＞a2＞……＞an 那么a1在任何位置都可以存活 a2必须在a1后面才可以存活
	 * 因为路是无限长，所以概率是1/2 a3同理需要在a1和a2后面才能活，概率就是1/3 以此类推，期望是: 1+1/2+1/3+…..+1/n
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
