package com.java.leetcode.coding;

public class IsNumberForString {
	/**
	 * ①对字符串中的每个字符进行判断分析
	 * ②e（E）后面只能接数字，并且不能出现2次
	 * ③对于+、-号，只能出现在第一个字符或者是e的后一位
	 * ④对于小数点，不能出现2次，e后面不能出现小数点
	 * */
	
	public boolean isNumeric(char[] str) {
		if(str.length == 0 || str == null) {
			return true;
		}
		boolean sign = false; // 正负符号
		boolean decimal = false; // 小数点
		boolean hasE = false; // E/e符号
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
