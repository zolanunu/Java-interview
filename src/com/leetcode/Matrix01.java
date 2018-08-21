/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class Matrix01 {
	/**
	 * 定一个数组metrix，数组中只包含1和0，且数组中的1都不相邻，输入一个数n，问能否在将数组中n个0替代换成1后不破坏1都不相邻的条件。
	 * 例1 metrix=[1,0,0,0,1],n=1输出true
	 * 例2 metrix=[1,0,0,0,1],n=2输出false
	 * */
	public boolean matrixchange(int[][] matrix, int n) {
		if(matrix.length == 0 || matrix == null) {
			return true;
		}
		if(countzero(matrix) < n) {
			return false;
		}
		int count = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0 && isMatch(matrix, i, j)) {
					count++;
				}
			}
		}
		
		if(count >= n) {
			return true;
		}
		return false;
	}
	public int countzero(int[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	public boolean isMatch(int[][] matrix, int i, int j) {
		if(i==0) {
			if(matrix[i][j-1] == 0 && matrix[i][j+1] == 0) {}
		}
		return false;
	}
}
