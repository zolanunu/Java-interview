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
			// �������
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
	     * ���������㷨
	     *
	     * @param matrix     �������
	     * @param rows       ��������
	     * @param cols       ��������
	     * @param str        Ҫ�������ַ���
	     * @param visited    �L�ʱ������
	     * @param row        ��ǰ������к�
	     * @param col        ��ǰ������к�
	     * @param pathLength �Ѿ������str���ַ�����
	     * @return �Ƿ��ҵ� true�ǣ�false��
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
				// ��ʼ����
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
