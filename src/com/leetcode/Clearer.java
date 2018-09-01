/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class Clearer {
	public int[][] clearZero(int[][] mat, int n) {
		boolean[] row = new boolean[mat.length];
		boolean[] column = new boolean[mat[0].length];
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(row[i] || column[j]) {
					mat[i][j] = 0;
				}
			}
		}
		return null;
	}
}
