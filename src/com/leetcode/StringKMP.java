package com.java.leetcode.coding;

public class StringKMP {
	/**
	 * 字符串中的模式匹配问题 在主串中找模式串第一次出现的第一个字符的下标
	 * */

	public int[] next(String b) {
		int len = b.length();
		int j = 0;

		int next[] = new int[len + 1];
		next[0] = next[1] = 0;

		for (int i = 1; i < len; i++) {
			while (j > 0 && b.charAt(i) != b.charAt(j)) {
				j = next[j];
			}
			if (b.charAt(i) == b.charAt(j)) {
				j++;
			}
			next[i + 1] = j;
		}
		return next;
	}

	public void search(String original, String find, int next[]) {
		int j = 0;
		for (int i = 0; i < original.length(); i++) {
			while (j > 0 && original.charAt(i) != find.charAt(j))
				j = next[j];
			if (original.charAt(i) == find.charAt(j))
				j++;
			if (j == find.length()) {
				System.out.println("find at position " + (i - j));
				System.out.println(original.subSequence(i - j + 1, i + 1));
				j = next[j];
			}
		}
	}

	public static int kmp(String str, String dest, int[] next) {// str文本串 dest
																// 模式串
		for (int i = 0, j = 0; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == dest.charAt(j)) {
				j++;
			}
			if (j == dest.length()) {
				return i - j + 1;
			}
		}
		return 0;
	}

	public static int[] kmpnext(String dest) {
		int[] next = new int[dest.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < dest.length(); i++) {
			while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
				j = next[j - 1];
			}
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
