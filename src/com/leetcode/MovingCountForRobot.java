package com.java.leetcode.coding;

public class MovingCountForRobot {
	/**
	 * 机器人在0*0的位置开始从四周方向走一格
	 * 给定一个k，机器人所走过的位置的坐标和（是坐标的各个位数上的数的求和）不能超过k
	 * */
	public static int movingCount(int threshold, int rows, int cols) {
		if(threshold < 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		boolean[] visited = new boolean[rows*cols];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		int count = countHelper(threshold, rows, cols, 0, 0, visited);
		return count;
	}
	public static int countHelper(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if(row >= 0 && row < rows 
			&& col >= 0 && col < cols
			&& !visited[row*cols+col] && (getDigitSum(row)+getDigitSum(col)) <= threshold) {
			visited[row*cols+col] = true;
			count = 1 + countHelper(threshold, rows, cols, row, col-1, visited)
					  + countHelper(threshold, rows, cols, row, col+1, visited)
					  + countHelper(threshold, rows, cols, row-1, col, visited)
					  + countHelper(threshold, rows, cols, row+1, col, visited);
		}
		return count;
	}
	public static int getDigitSum(int row) {
		int sum = 0;
		int temp = row;
		while(temp > 0) {
			
			sum = sum + temp % 10;
			temp = temp / 10;
		}
		return sum;
	}
	public static void main(String[] args) {
		int result = movingCount(4, 6, 6);
		System.out.println("k = 4 , 在 6 * 6 的方格中的数量是：" + result);
	}
}
