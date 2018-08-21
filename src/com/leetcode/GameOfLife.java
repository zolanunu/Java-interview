package com.java.leetcode.coding;

public class GameOfLife {
	private int countLiveNeigh(int[][] board, int row, int col) {
		int count = 0;
		for(int i = row - 1; i <= row + 1; i++ ) {
			for(int j = col - 1; j <= col + 1; j++) {
				if(i == row && j == col) {
					continue;
				}
				if(i >= 0 && i < board.length && j > 0 && j < board[0].length && (board[i][j] == 1 || board[i][j] == 2 )) {
					count++;
				}
			}
		}
		return count;
	}
	
	public void gameOfLife(int[][] board) {
		int rowlen = board.length;
		int collen = board[0].length;
		for(int i = 0; i < rowlen; i++) {
			for(int j = 0; j < collen; j++) {
				int count = countLiveNeigh(board, i, j);
				if(count == 2);
				else if(count == 3) {
					board[i][j] = board[i][j] == 0 ? 3 : 1;
				} else {
					board[i][j] = board[i][j] == 1 ? 2 : 0;
				}
			}
		}
		
		for(int i = 0; i < rowlen; i++) {
			for(int j = 0; j < collen; j++) {
				board[i][j] %= 2;
			}
		}
	}
}
