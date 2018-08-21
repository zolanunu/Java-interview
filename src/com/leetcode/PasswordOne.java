/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class PasswordOne {
	// 一个字符串S,牛牛还记得从S中去掉一个字符就恰好是正确的密码,请你帮牛牛求出他最多需要尝试多少次密码。
	// 如果没有相邻的重复字母，则次数即为字符串的长度//每有一对相邻的重复字母，就会有一次重复，因此次数减一
	
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
