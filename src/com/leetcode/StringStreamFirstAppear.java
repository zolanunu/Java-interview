package com.java.leetcode.coding;

public class StringStreamFirstAppear {
	
	private int[] occurence = new int[256]; // ����һ��int�������ʾ256���ַ�����������ֵ��Ϊ-1.
	private int index;
	
	public StringStreamFirstAppear() {
		for(int i = 0; i < 256; i++) {
			occurence[i] = -1;
		}
		index = 0;
	}
	
	void insert(char ch) {
		// ��ֵΪ-1��ʶ��һ�ζ��룬��Ϊ-1�ҡ�0��ʾ���ǵ�һ�ζ��룬��ֵ��Ϊ-2.
		if(occurence[ch] == -1) {
			occurence[ch] = index; // ��һ�γ���
		} else if(occurence[ch] >= 0) {
			occurence[ch] = -2; // ���ǵ�һ�γ���
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
