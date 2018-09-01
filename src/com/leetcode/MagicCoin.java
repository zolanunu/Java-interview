/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class MagicCoin {
	public String magicCoin(int n) {
		//if(n == 1) {}
		String res = null;
		while(n > 0) {
			if(n % 2 == 0) {
				res+='2';
				n = (n - 2) / 2;
			} else {
				res+='1';
				n = (n - 1) /2;
			}
		}
		String resver = null;
		for(int i = res.length()-1; i >= 0; i--) {
			resver += res.charAt(i);
		}
		return resver;
	}
}
