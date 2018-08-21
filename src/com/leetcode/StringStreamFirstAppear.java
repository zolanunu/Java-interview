package com.java.leetcode.coding;

public class StringStreamFirstAppear {
	
	private int[] occurence = new int[256]; // 利用一个int型数组表示256个字符，这个数组初值置为-1.
	private int index;
	
	public StringStreamFirstAppear() {
		for(int i = 0; i < 256; i++) {
			occurence[i] = -1;
		}
		index = 0;
	}
	
	void insert(char ch) {
		// 若值为-1标识第一次读入，不为-1且》0表示不是第一次读入，将值改为-2.
		if(occurence[ch] == -1) {
			occurence[ch] = index; // 第一次出现
		} else if(occurence[ch] >= 0) {
			occurence[ch] = -2; // 不是第一次出现
		}
		index++;
	}
	char firstAppearingOnce() {
		char ch = ' ';
		int minindex = Integer.MAX_VALUE;
		for(int i = 0; i < 256; i++) {
			if(occurence[i] >= 0 && occurence[i] < minindex) {
				ch = (char)i;
				minindex = occurence[i];
			}
		}
		if(ch == ' ') {
			return '#';
		}
		return ch;
		
	}
}
