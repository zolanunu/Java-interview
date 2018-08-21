package com.java.leetcode.coding;

public class IsNumberForString {
	/**
	 * �ٶ��ַ����е�ÿ���ַ������жϷ���
	 * ��e��E������ֻ�ܽ����֣����Ҳ��ܳ���2��
	 * �۶���+��-�ţ�ֻ�ܳ����ڵ�һ���ַ�������e�ĺ�һλ
	 * �ܶ���С���㣬���ܳ���2�Σ�e���治�ܳ���С����
	 * */
	
	public boolean isNumeric(char[] str) {
		if(str.length == 0 || str == null) {
			return true;
		}
		boolean sign = false; // ��������
		boolean decimal = false; // С����
		boolean hasE = false; // E/e����
		for(int i = 0; i<str.length; i++) {
			if(str[i] == 'e' || str[i] == 'E') {
				if(i == str.length - 1) {return false;}
				if(hasE) {return false;}
				hasE = true;
			} else if(str[i] == '+' || str[i] == '-') {
				if(sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
					return false;
				}
				if(!sign && i > 0 && str[i -1] != 'e' && str[i-1]!='E') {
					return false;
				}
				sign = true;
			} else if(str[i] == '.') {
				if(hasE || decimal) {return false;}
				decimal = true;
			} else if(str[i] < '0' || str[i] > '9') {
				return false;
			}
		}
		return true;
		
	}
	
}
