package com.leetcode;

import java.util.Scanner;

public class NiuNiuGame {
	/**
	 * 牛牛很喜欢玩接龙游戏，一天他突发奇想，发明了�?种叫做�?�字符串链�?�的游戏�? 这个游戏的规则是这样的，给出3个字符串A，B，C，如果它们满足以下两个条件，那么就可以构成一个�?�字符串链�?�： 
	 * 1.A的最后一个字母和B的第�?个字母相同；
	 * 2.B的最后一个字母和C的第�?个字母相同�??
	 * 现在牛牛给出�?3个字符串A，B，C，希望你能判断这3个字符串能否构成�?个�?�字符串链�?�，若能则输出�?�YES”，否则输出“NO”�??
	 * */
	
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		String A = inScanner.next(), B=inScanner.next(), C=inScanner.next();
		if(A.length()<1||A.length()>10||B.length()<1||B.length()>10||C.length()<1||C.length()>10) {
			return ;
		}
		if(A.charAt(A.length()-1)==B.charAt(0)&&B.charAt(B.length()-1)==C.charAt(0)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		inScanner.close();
	}
}
