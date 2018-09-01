/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class LCSequence {
	// 最长公共子序列
	public static int lcs(String s1, String s2) {
		if(s1==null||s1.length()==0 || s2.length()==0||s2==null) {
			return 0;
		}
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] c = new int[l1+1][l2+1];
		for(int i = 0; i <= l1; i++) {
			c[i][0] = 0;
		}
		for(int i = 0; i <= l2; i++) {
			c[0][i] = 0;
		}
		
		for(int i = 1; i <= l1; i++) {
			for(int j = 1; j <= l2; j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					c[i][j] = c[i-1][j-1]+ 1;
				} else if(c[i][j-1] > c[i-1][j]) {
					c[i][j] = c[i][j-1];
				} else {
					c[i][j] = c[i-1][j];
				}
			}
		}
		return c[l1][l2];
	}
}
