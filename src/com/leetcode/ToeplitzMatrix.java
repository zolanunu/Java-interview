/**
 * 
 */
package com.leetcode;
/**
 * @author zolanunu
 *
 */
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		if(col == 1 || row == 1) {
			return true;
		}
		if(isLeft(matrix, row, col) && isRight(matrix, row, col) && isDiagonal(matrix, row, col)) {
			return true;
		}
		return false;
	}
	public boolean isRight(int[][] matrix, int row, int col) {
		for(int i = 1; i < col; i++) {
			int j = i+1, k = 1;
			while(j < col && k < row) {
				if(matrix[0][i] == matrix[k++][j++]) {
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isLeft(int[][] matrix, int row, int col) {
		for(int i = 1; i < row; i++) {
			int j = i+1, k = 1;
			while(j < row && k < col) {
				if(matrix[i][0] == matrix[j++][k++]) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isDiagonal(int[][] matrix, int row, int col) {
		int j = 1, k = 1;
		while(j <row && k < col) {
			if(matrix[0][0] == matrix[j++][k++]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2},{2,2}};
		ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
		System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
	}
}
