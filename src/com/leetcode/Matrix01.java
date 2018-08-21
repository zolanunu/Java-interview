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
	 * ��һ������metrix��������ֻ����1��0���������е�1�������ڣ�����һ����n�����ܷ��ڽ�������n��0�������1���ƻ�1�������ڵ�������
	 * ��1 metrix=[1,0,0,0,1],n=1���true
	 * ��2 metrix=[1,0,0,0,1],n=2���false
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
