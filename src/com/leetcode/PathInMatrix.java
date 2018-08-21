package com.java.leetcode.coding;

public class PathInMatrix {
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    {
	  		if(matrix.length!=cols*rows|| matrix==null||str==null||str.length<1) {
				return false;
			}
			
			boolean[] visited = new boolean[rows*cols];
			for(int i = 0; i < visited.length; i++) {
				visited[i] = false;
			}
			// 结果数组
			int[] pathLen = {0};
			for(int i =0 ; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(hasPathCore(matrix, rows, cols, str, visited, i, j, pathLen)) {
						return true;
					}
				}
			}
			return false;
		}
		
		/**
	     * 回溯搜索算法
	     *
	     * @param matrix     输入矩阵
	     * @param rows       矩阵行数
	     * @param cols       矩阵列数
	     * @param str        要搜索的字符串
	     * @param visited    訪问标记数组
	     * @param row        当前处理的行号
	     * @param col        当前处理的列号
	     * @param pathLength 已经处理的str中字符个数
	     * @return 是否找到 true是，false否
	     */
		public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int[] pathLen) {
			if(pathLen[0] == str.length) {
				return true;
			}
			boolean hasPath = false;
			if(row>=0&&row<rows&&col>=0&&col<cols
				&& matrix[row*cols+col]==str[pathLen[0]]
				&& !visited[row*cols+col]) {
				visited[row*cols+col] = true;
				pathLen[0]++;
				// 开始回溯
				 hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLen)
		                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLen)
		                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLen)
		                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLen);
				 if (!hasPath) {
		                pathLen[0]--;
		                visited[row * cols + col] = false;
		            }
			}
			return hasPath;
		}
}
