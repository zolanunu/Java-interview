/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class Transform {
	
	public int[][] transformImage(int[][] mat, int n) {
		for(int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = mat[first][i];
				mat[first][i] = mat[last-offset][first];
				mat[last-offset][first] = mat[last][last-offset];
				mat[last][last-offset] = mat[i][last];
				mat[i][last] = top;
			}
		}
		return mat;
	}
}
