package com.java.leetcode.coding;

import java.util.Scanner;
import java.util.Stack;

public class MatchForKuohao {

	/**
	 * �?般的括号匹配问题是这样的�? 给出�?个字符串，判断这个括号匹配是不是合法的括号匹配�?? �?"((" �?
	 * "())"都不是合法的括号匹配，但�?"()()()"�?"(()())()"等就是合法的括号匹配�? 这个问题解决起来非常�?单，相信大家都知道�?�么解决�?
	 * 现在给出�?个加强版的括号匹配问题： 给出n个由括号 '(' �? �?)�? 组成的字符串，请计算出这些字符串中有多少对字符串满足si +
	 * sj是合法的括号匹配。如果si + sj和sj + si都是合法的括号匹�?(i �? j)，那么这两种搭配都需要计入答案；如果对于si，si +
	 * si是合法的括号匹配，那么也�?要计入答案�??
	 */
	/**
	 * 1. 合法判断：去除字符串中形�?"()"，直到不能去除为止，若字符串被清理为空，那么字符串合法，否则字符串不合法�?
	 * 变成以下三种�?"(...("�?")...)"�?")...)(...("。�?�虑清理之后的字符串�?
	 * n个字符串中，合法的字符串有num1个，不合法的字符串中，只�?"(...("�?")...)"能配成一组，二重循环遍历不合法字符串，配对数为num2�? 2.
	 * �?终结果为num1*num1+num2�?
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String ns = input.nextLine();
		int n = Integer.parseInt(ns);
		String[] strs = new String[n];
		int[][] flag = new int[n][2];
		int k = 0;
		for (int i = 0; i < n; i++) {
			strs[i] = input.nextLine();
			flag[i] = isEqual2(strs[i]);
		}
		for (int i = 0; i < n; i++) {
			if (flag[i][0] == 3) {
				for (int j = 0; j < n; j++) {
					if (flag[j][0] == 3)
						k++;
				}
			} else {
				if (flag[i][0] == 0) {
					for (int h = 0; h < n; h++) {
						if (flag[h][0] == 1 && flag[h][1] == flag[i][1])
							k++;
					}
				}
			}
		}
		input.close();
		System.out.println(k);
	}

	public static int[] isEqual2(String s) {
		int n = s.length();
		char[] ch1 = new char[n];
		int[] flag = new int[2];
		ch1 = s.toCharArray();
		Stack<Character> sc = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (ch1[i] == '(') {
				sc.push(ch1[i]);
			} else {
				if ((sc.size() > 0) && (sc.peek() == '(')) {
					sc.pop();
				} else {
					sc.push(ch1[i]);
				}
			}
		}
		if (sc.size() == 0) {
			flag[0] = 3;
			flag[1] = 0;
			return flag;
		} else {
			int slen = sc.size();
			char[] ch2 = new char[sc.size()];
			for (int i = sc.size() - 1; i > -1; i--) {
				ch2[i] = sc.pop();
			}
			if (ch2[0] == ch2[slen - 1]) {
				if (ch2[0] == '(') {
					flag[0] = 0;
					flag[1] = slen + 1;
					return flag;
				} else {
					flag[0] = 1;
					flag[1] = slen + 1;
					return flag;
				}
			} else {
				flag[0] = 2;
				flag[1] = 0;
				return flag;
			}
		}

	}
}
