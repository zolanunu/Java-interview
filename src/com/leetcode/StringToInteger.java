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
	 * �ַ���תΪ����
	 * һ���������������⣬��һ��������Խ������
	 * ˼·�Ƚϼ򵥣�������ȥ������Ŀո��ַ���Ȼ�������
	 * Ȼ��˳���ȡ�ַ��������������ǣ������������ַ�+�ַ�������+Խ�磨һ��Խ��ͷ��أ�
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
