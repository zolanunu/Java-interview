/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ReshapeTheMatrix {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int row = nums.length, col = nums[0].length;
		if(row == 0 || row * col != r * c) {
			return nums;
		}
		int[][] numsShape = new int[r][c];
		int[] snums = new int[row*col];
		int k = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				snums[k++] = nums[i][j];
			}
		}
		k = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				numsShape[i][j] = snums[k++];
			}
		}
		return numsShape;
	}
	
	public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int[][] m = {{1,2},{3,4}};
		int r = 1, c = 4;
		int[][] n = matrixReshape(m, r, c);
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(n[i][j]);
			}
			System.out.println();
		}
	}
}
