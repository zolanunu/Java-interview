package com.leetcode;

import java.util.ArrayList;

public class PrintMatrix {
	/**
	 * 剑指offer：顺时针打印矩阵
	 * */
	
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int r = matrix.length;
		
		int c = matrix[0].length;
		int total = r * c;
		int i = 0, j = 0;
		int right_c = c;
		int right_r = r;
		int left_r = 0;
		int left_c = 0;
		
		while(total>0) {
			//System.out.println("total =" +total+ " right_c="+right_c+" right_r="+right_r+" left_r="+left_r+" left_c="+left_c);
			// 从左往右打印
			while(total>0&&j<right_c) {
				list.add(matrix[i][j]);
				total--;
				j++;
			}
			//System.out.println("before: i="+i+" j="+j);
			j--;
			i++;
			//System.out.println("after: i="+i+" j="+j);
			// 从上往下打印
			while(total > 0 && i < right_r-1) {
				list.add(matrix[i][j]);
				i++;
				total--;
			}
			//System.out.println("before: i="+i+" j="+j);
			i--;
			j--;
			//System.out.println("after: i="+i+" j="+j);
			// 从右往左打印
			while(total>0&&j >= left_c) {
				list.add(matrix[i][j]);
				total--;
				j--;
			}
			//System.out.println("before: i="+i+" j="+j);
			j++;
			i--;
			//System.out.println("after: i="+i+" j="+j);
			// 从下往上打印
			while(total>0&&i>left_r) {
				total--;
				i--;
			}
			//System.out.println("before: i="+i+" j="+j);
			i++;
			j++;
			//System.out.println("after: i="+i+" j="+j);
			right_c--;
			right_r--;
			left_c++;
			left_r++;
			//System.out.println("total =" +total+ " right_c="+right_c+" right_r="+right_r+" left_r="+left_r+" left_c="+left_c);
		}
		return list;
	}
	
	public static void printMatrixClockWisely(int[][] numbers) {
        // 输入的参数不能为空
        if (numbers == null) {
            return;
        }
        // 记录一圈（环）的开始位置的行
        int x = 0;
        // 记录一圈（环）的开始位置的列
        int y = 0;
        // 对每一圈（环）进行处理，
        // 行号最大是(numbers.length-1)/2
        // 列号最大是(numbers[0].length-1)/2
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            // 指向下一个要处理的的环的第一个位置
            x++;
            y++;
        }
    }
    public static void printMatrixInCircle(int[][] numbers, int x, int y) {
        // 数组的行数
        int rows = numbers.length;
        // 数组的列数
        int cols = numbers[0].length;
        // 输出环的上面一行，包括最中的那个数字
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }
        // 环的高度至少为2才会输出右边的一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (rows - x - 1 > x) {
            // 因为右边那一列的最上面那一个已经被输出了，所以行呈从x+1开始，
            // 输出包括右边那列的最下面那个
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }
        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols-1-y：表示的是环最右那一列的列号
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // 因为环的左下角的位置已经输出了，所以列号从cols-y-2开始
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }
        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // 因为最左边那一列的第一个和最后一个已经被输出了
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,2},{3,4}};
		ArrayList<Integer> list = printMatrix(matrix);
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
