package com.leetcode;

public class HahPathCore {
	/**
	 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
	 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
	 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ�
	 * ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·����
	 * ���Ǿ����в�����"abcb"·������Ϊ
	 * �ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
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
