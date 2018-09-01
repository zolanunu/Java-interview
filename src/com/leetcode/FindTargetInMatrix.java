package com.leetcode;
public class FindTargetInMatrix {
	public static boolean find(int target, int[][] array) {
		if(array==null||array.length==0||array[0].length==0) {
			return false;
		}
		int n = array.length;
		int m = array[0].length;
		if(target < array[0][0] || array[n-1][m-1]<target) {
			return false;
		}
		int col = m-1, row = 0;
		while(col>=0){
			while(row<=n-1 && col >= 0) {
				if(array[row][col]<target) {
					row++;
					// continue;
				} else if (array[row][col]>target) {
					col--;
					//break;
				} else {
					return true;
				}
				System.out.println("col = " + col + "row = " + row);
			}
			col--;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int target = 1;
		System.out.println(find(target, arr));
		
	}
}
