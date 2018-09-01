package com.leetcode;

public class HahPathCore {
	/**
	 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
	 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
	 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
	 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
	 * 但是矩阵中不包含"abcb"路径，因为
	 * 字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
	 * */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix.length != cols *cols || matrix == null 
				|| str == null || str.length <= 0) {
			return false;
		}
		boolean[] visited = new boolean[cols*rows];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		int[] pathLen = {0};
		for(int i = 0; i <rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(hasPathCore(matrix, rows, cols, str, visited, i, j, pathLen)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasPathCore(char[] matrix, int cols, int rows, char[] str, boolean[] visited, int row, int col, int[] pathLen) {
		if(pathLen[0] == str.length) {
			return true;
		}
		boolean hasPath = false;
		if(row >= 0 && row < rows && col >= 0 && col < cols
			&& matrix[row*cols+col] == str[pathLen[0]]
			&& !visited[row*cols+col] == true) {
			pathLen[0]++;
			hasPath = hasPathCore(matrix, cols, rows, str, visited, row, col-1, pathLen)
					|| hasPathCore(matrix, cols, rows, str, visited, row, col+1, pathLen)
					|| hasPathCore(matrix, cols, rows, str, visited, row-1, col, pathLen)
					|| hasPathCore(matrix, cols, rows, str, visited, row+1, col, pathLen);
			if(!hasPath) {
				pathLen[0]--;
				visited[row*cols+col] = false;
			}
		}
		return hasPath;
	}
}
