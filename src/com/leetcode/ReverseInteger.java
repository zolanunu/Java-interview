/**
 * 
 */
package com.java.leetcode.coding;

import java.util.InputMismatchException;

/**
 * @author zolanunu
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		long res = 0;
		while(x!=0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		System.out.println(res);
		if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) { // Òç³ö
			throw new InputMismatchException();
		}
		return (int)res;
	}
}
