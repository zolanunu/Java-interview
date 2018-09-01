package com.leetcode;

public class RobotSport {
	public int move(int threshold, int rows, int cols) {
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
	
	public int countHelper(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if(row >= 0 && row < rows && col >= 0 && col < cols
			&& !visited[row*cols+col] && (getDigitSum(row)+getDigitSum(col)) <= threshold) {
			visited[row*cols+col] = true;
			count = 1 + countHelper(threshold, rows, cols, row-1, col, visited)
			+ countHelper(threshold, rows, cols, row, col-1, visited)
			+ countHelper(threshold, rows, cols, row+1, col, visited)
			+ countHelper(threshold, rows, cols, row, col+1, visited);
		}
		return 0;
	}
	
	public int getDigitSum(int num) {
		if(num > 0 && num < 10) {
			return num;
		}
		int sum = 0;
		while(num > 0) {
			//num = num % 10;
			System.out.println(num);
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		RobotSport sport = new RobotSport();
		System.out.println(sport.getDigitSum(45));
	}
}
