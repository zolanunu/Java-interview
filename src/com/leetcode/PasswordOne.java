/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class PasswordOne {
	// һ���ַ���S,ţţ���ǵô�S��ȥ��һ���ַ���ǡ������ȷ������,�����ţţ����������Ҫ���Զ��ٴ����롣
	// ���û�����ڵ��ظ���ĸ���������Ϊ�ַ����ĳ���//ÿ��һ�����ڵ��ظ���ĸ���ͻ���һ���ظ�����˴�����һ
	
	public static int passwordOne(String s) {
		char[] sc = s.toCharArray();
		int n = sc.length;
		for(int i = 1; i < sc.length; i++) {
			if(sc[i] == sc[i - 1]) {
				n--;
			}
		}
		return n;
	}
	
}
