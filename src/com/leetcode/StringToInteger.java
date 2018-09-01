/**
 * 
 */
package com.leetcode;
/**
 * @author zolanunu
 *
 */
public class StringToInteger {
	/**
	 * 字符串转为数字
	 * 一个是正负符号问题，另一个是整数越界问题
	 * 思路比较简单，就是先去掉多余的空格字符，然后读符号
	 * 然后按顺序读取字符串，结束条件是：非数字类型字符+字符串结束+越界（一旦越界就返回）
	 * */
	public int atoi(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		s = s.trim();
		boolean flag = false;
		int i = 0;
		if(s.charAt(0) == '-') {
			flag = true;
			i++;
		} else if(s.charAt(0) == '+') {
			i++;
		}
		int result = 0;
		while(i < s.length()) {
			if(s.charAt(i)<'0'||s.charAt(i)>'9') {
				break;
			}
			int digit = (int) (s.charAt(i)-'0');
			if(flag && result>-((Integer.MIN_VALUE+digit)/10)) {
				return Integer.MIN_VALUE;
			} else if(!flag && result>(Integer.MAX_VALUE-digit)/10) {
				return Integer.MAX_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}
		return flag ? -result : result;
	}
}
