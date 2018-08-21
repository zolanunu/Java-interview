/**
 * 
 */
package com.java.leetcode.coding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zolanunu
 * 
 */
public class SurroundedRegions {
	/**
	 * 把包圍住的O变为X
	 * */
	char[][] board;
	int rows;
	int cols;
	Queue<Integer> que = new LinkedList<Integer>();

	public void changeOtoX(char[][] board) {
		int rows, cols;
		rows = board.length;
		if (rows < 3) {
			return;
		}
		cols = board[0].length;
		if (cols < 3) {
			return;
		}
		for(int col = 0; col < cols; col++) {
			if(board[0][col] == 'O') {
				board[0][col] = '#';
			}
			if(board[rows-1][col] == 'O') {
				board[rows-1][col] = '#';
			}
		}
		
		// 第一列 最后一列
		for(int row = 0; row < rows; row++) {
			if(board[row][0] == 'O') {
				board[row][0] = '#';
			}
			if(board[row][cols-1] == 'O') {
				board[row][cols-1] = '#';
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O' && isSurroundedByX(board, i, j)) {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	public boolean isSurroundedByX(char[][] board, int i, int j) {
		if(i > 0 && i < board.length-1 && j > 0 && j < board[0].length) {
			if(board[i-1][j] == 'X' && board[i+1][j] == 'X' &&
				board[i][j-1] == 'X' && board[i][j+1] == 'X') {
				return true;
			}
		}
		return false;
	}
	public void takeEdge(char[][] board) {
		if(board == null || board.length == 0) {
			return ;
		}
		int rows = board.length;
		int cols = board[0].length;
		// 第一行 和 最后一行
		for(int col = 0; col < cols; col++) {
			if(board[0][col] == 'O') {
				board[0][col] = '#';
			}
			if(board[rows-1][col] == 'O') {
				board[rows-1][col] = '#';
			}
		}
		
		// 第一列 最后一列
		for(int row = 0; row < rows; row++) {
			if(board[row][0] == 'O') {
				board[row][0] = '#';
			}
			if(board[row][cols-1] == 'O') {
				board[row][cols-1] = '#';
			}
		}
		
		
	}
	public void bfs(int i, int j) {
		fill(i, j);
		while (!que.isEmpty()) {
			int pos = que.poll();
			int x = pos / cols;
			int y = pos % cols;

			fill(x - 1, y);
			fill(x + 1, y);
			fill(x, y - 1);
			fill(x, y + 1);
		}
	}

	public void fill(int i, int j) {
		if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1)
			return;
		if (board[i][j] != 'O')
			return;
		que.offer(i * cols + j);
		board[i][j] = '#';
	}
}
