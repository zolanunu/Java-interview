/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class FindNumInArr {
	/**
	 * 剑指offer：面试题4：
	 * 在二维数组中查找元素
	 * */
	
	public static boolean find(int[][] arr, int target) {
		/**
		 * 从最后一列开始逐个进行排查
		 * */
		int cols = arr[0].length;
		int rows = arr.length;
		if(arr == null || cols <= 0 || rows <= 0 || target < arr[0][0] || target > arr[rows-1][cols-1]) {
			return false;
		}
		int row = 0;
		int col = cols - 1;
		while(col >= 0 && row < rows) {
			if(arr[row][col] == target) {
				return true;
			} else if(arr[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int cols = inScanner.nextInt();
		int rows = inScanner.nextInt();
		
		int[][] arr = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				arr[i][j] = inScanner.nextInt();
			}
		}
		int target = inScanner.nextInt();
		
		System.out.println(find(arr, target));
	}
}
