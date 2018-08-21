/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class RobotMovingCount {
	/**
	 * �����˵��˶���Χ
	 * */
	public int movingCount(int threshold, int rows, int cols) {
		if(threshold < 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		boolean[] visited = new boolean[rows*cols];
		for(int  i = 0; i < visited.length; i++) {
			visited[i] =false;
		}
		int count = countHelper(threshold, rows, cols, 0, 0, visited);
		return count;
	}
	public int countHelper(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if(row>=0 && row<rows && col>=0 && 
			col<cols && !visited[row*cols+col] &&
			getDigitSum(row)+getDigitSum(col)<=threshold) {
			visited[row*cols+col] = true;
			count = 1 + countHelper(threshold, rows, cols, row, col-1, visited)
					+ countHelper(threshold, rows, cols, row-1, col, visited)
					+ countHelper(threshold, rows, cols, row, col+1, visited)
					+ countHelper(threshold, rows, cols, row+1, col, visited);
		}
		return count;
	}
	
	public int getDigitSum(int row) {
		int sum = 0;
		int temp = row;
		while(temp > 0) {
			sum += temp % 10;
			temp = temp / 10;
		}
		return sum;
	}
	
	public boolean check(int threshold,int rows,int cols,int col,int row,boolean[] visited) {  
	    if(row>=0 && row<rows && col>=0 && col<cols //�Ƿ�Խ�磻  
	        && getDigitSum(row)+getDigitSum(col)<=threshold//�Ƿ���threshold�ڣ�  
	        && !visited[row*cols+col])//�Ƿ��Ѿ����ʣ�  
	        return true;  
	    return false;  
	}
	public static void main(String[] args) {
		RobotMovingCount rMovingCount = new RobotMovingCount();
		int result = rMovingCount.movingCount(4, 6, 6);
		System.out.println("k = 4, �� 6 * 6 �ķ����е������ǣ�" + result);
	}
}
