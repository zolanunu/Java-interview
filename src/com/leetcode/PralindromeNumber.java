/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class PralindromeNumber {
	/**
	 * �ж����������ǹ��ǻ�������
	 * ����һ������
	 * 
	 * */
	
	public static boolean isPalindromeNumber(int x) {
		if(x < 0) {
			return false;
		}
		if(x >= 0 && x < 12 && x != 10) {
			return true;
		}
		return helper(x);
	}
	public static boolean helper(int x) {
		if(x < 0 || x > Integer.MAX_VALUE) {
			return false;
		}
		int temp = x;
		int y = 0;
		while(temp != 0) {
			y = y * 10 + temp%10;
			temp = temp / 10;
			System.out.println(temp + "temp = ");
		}
		System.out.println(y);
		if(y == x) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int x = 121;
		System.err.println(isPalindrome1(x));
	}
	
	public static boolean isPalindrome1(int x) {
		int left, right, len = 1;
		if(x > Integer.MAX_VALUE || x < 0) {
			return false;
		}
		if(x < 12 && x != 10) {
			return true;
		}
		while(x / len >= 10) {
			len = len * 10;
		}
		while(x != 0) {
			left = x / len; // ���λ
			right = x % 10; // ���λ
			if(left != right) {
				return false;
			}
			x = (x % len) / 10; // ���˵����λ�����λ
			len = len / 100;
		}
		return true;
	}
}
