/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ImageSmoother {
	public static int[][] imageSmoother(int[][] M) {
		int size = M.length;
		int[][] N = new int[size][size];
//		for(int i = 0; i < size; i++) {
//			for(int j = 0; j < size; j++) {
//				System.out.print(N[i][j]+ " ");
//			}
//			System.out.println();
//		}
		if(size <= 2) {
			return N;
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(i == 0 && j == 0) {
					N[i][j] =  (int)Math.floor((M[i][j]+M[i+1][j]+M[i+1][j+1] + M[i][j+1]) / 4);
				}else if(i == 0 && j == size -1) {
					N[i][j] =  (int)Math.floor((M[i][j]+M[i+1][j]+M[i][j-1] + M[i][j+1]) / 4);
				}else if(i == size-1 && j == 0) {
					N[i][j] =  (int)Math.floor((M[i][j]+M[i+1][j]+M[i+1][j+1] + M[i][j+1]) / 4);
				}else if(i == size-1 && j == size -1) {
					N[i][j] =  (int)Math.floor((M[i][j]+M[i+1][j]+M[i+1][j+1] + M[i][j+1]) / 4);
				}else if(i == 0 &&j>0&&j<size-1) {
					N[i][j] = (int)Math.floor((M[i][j]+M[i+1][j]+M[i+1][j+1]+M[i][j+1]+M[i+1][j-1])+M[i][j-1] / 6);
				}else if(i == size-1&& j >0&&j<size-1) {
					N[i][j] = (int)Math.floor((M[i][j]+M[i-1][j]+M[i-1][j-1]+M[i][j+1]+M[i][j-1])+M[i-1][j+1] / 6);
				}else if(j == size-1&& i >0&&i<size-1) {
					N[i][j] = (int)Math.floor((M[i][j]+M[i-1][j-1]+M[i][j-1]+M[i+1][j-1]+M[i+1][j])+M[i-1][j]/6);
				}
				else if(j == 0&& i > 0&&i<size-1) {
					N[i][j] = (int)Math.floor((M[i][j]+M[i-1][j]+M[i-1][j+1]+M[i][j+1]+M[i+1][j])+M[i+1][j+1]/6);
				}
				else if(j == size-1&& i >0&&i<size-1) {
					N[i][j] = (int)Math.floor((M[i][j]+M[i-1][j]+M[i-1][j-1]+M[i][j-1]+M[i+1][j-1])+M[i+1][j]/6);
				}else {
					int x = M[i][j] + M[i-1][j] + M[i+1][j]+M[i][j-1]+M[i][j+1]+M[i-1][j-1]+M[i+1][j+1]+M[i-1][j+1]+M[i+1][j-1];
					N[i][j] = (int) Math.floor(x/9);
				}
			}
		}
		return N;
	}
	public static void main(String[] args) {
		int[][] M  = {{1, 0, 1}, {0, 1, 0}, {0, 1, 0}};
		int size = M.length;
		int[][] N = imageSmoother(M);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(N[i][j]+ " ");
			}
		System.out.println();
		}
	}
}
