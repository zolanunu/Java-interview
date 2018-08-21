/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ReverseNumber {
	
	// 反转数字的各个数位
	public static int reverseNumber(int n) {
		int re = reverse(n);
		return re + n;
	}
	
	public static int reverse(int n) {
		int x = 0;
		int re = 0;
		if(n <= 10) {
			return n;
		} else {
			while(n > 0) {
				re = n % 10;
				n = n / 10;
				x = x * 10 + re;
			}
			return x;
		}
	}
	public static void main(String[] args) {
		int s = reverseNumber(1325);
		System.out.println(s);
	}
}
