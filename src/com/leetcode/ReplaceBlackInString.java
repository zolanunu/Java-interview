	/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ReplaceBlackInString {
	/**
	 * ��ָoffer ������5��
	 * �滻�ո�
	 * 
	 * */
	
	public static String replace(String s) {
		return s.replace(" ", "%20");
	}
	public static void main(String[] args) {
		System.out.println(replace("We are Happy"));
		StringBuffer s = new StringBuffer("We are Happy");
		System.out.println(replace1(s));
	}
	
	public static String replace1(StringBuffer s) {
		/**
		 * ���û�����ƣ�Ȼ������ַ����������ո�������%20
		 * */
		if(s == null || s.length() == 0) {
			return s.toString();
		}
		String sw = s.toString();
		s.delete(0, s.length());
		for(int i = 0; i < sw.length(); i++) {
			if(sw.charAt(i) != ' ') {
				s.append(sw.charAt(i));
			} else {
				s.append("%20");
			}
		}
		return s.toString();
	}
	
}
