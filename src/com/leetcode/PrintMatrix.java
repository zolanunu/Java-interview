package com.leetcode;

import java.util.ArrayList;

public class PrintMatrix {
	/**
	 * ��ָoffer��˳ʱ���ӡ����
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
			// �������Ҵ�ӡ
			while(total>0&&j<right_c) {
				list.add(matrix[i][j]);
				total--;
				j++;
			}
			//System.out.println("before: i="+i+" j="+j);
			j--;
			i++;
			//System.out.println("after: i="+i+" j="+j);
			// �������´�ӡ
			while(total > 0 && i < right_r-1) {
				list.add(matrix[i][j]);
				i++;
				total--;
			}
			//System.out.println("before: i="+i+" j="+j);
			i--;
			j--;
			//System.out.println("after: i="+i+" j="+j);
			// ���������ӡ
			while(total>0&&j >= left_c) {
				list.add(matrix[i][j]);
				total--;
				j--;
			}
			//System.out.println("before: i="+i+" j="+j);
			j++;
			i--;
			//System.out.println("after: i="+i+" j="+j);
			// �������ϴ�ӡ
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
        // ����Ĳ�������Ϊ��
        if (numbers == null) {
            return;
        }
        // ��¼һȦ�������Ŀ�ʼλ�õ���
        int x = 0;
        // ��¼һȦ�������Ŀ�ʼλ�õ���
        int y = 0;
        // ��ÿһȦ���������д���
        // �к������(numbers.length-1)/2
        // �к������(numbers[0].length-1)/2
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            // ָ����һ��Ҫ����ĵĻ��ĵ�һ��λ��
            x++;
            y++;
        }
    }
    public static void printMatrixInCircle(int[][] numbers, int x, int y) {
        // ���������
        int rows = numbers.length;
        // ���������
        int cols = numbers[0].length;
        // �����������һ�У��������е��Ǹ�����
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }
        // ���ĸ߶�����Ϊ2�Ż�����ұߵ�һ��
        // rows-x-1����ʾ���ǻ����µ���һ�е��к�
        if (rows - x - 1 > x) {
            // ��Ϊ�ұ���һ�е���������һ���Ѿ�������ˣ������гʴ�x+1��ʼ��
            // ��������ұ����е��������Ǹ�
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }
        // ���ĸ߶�������2���һ��Ŀ��������2�Ż����������һ��
        // cols-1-y����ʾ���ǻ�������һ�е��к�
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // ��Ϊ�������½ǵ�λ���Ѿ�����ˣ������кŴ�cols-y-2��ʼ
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }
        // ���Ŀ��������2���һ��ĸ߶�������3�Ż�����������һ��
        // rows-x-1����ʾ���ǻ����µ���һ�е��к�
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // ��Ϊ�������һ�еĵ�һ�������һ���Ѿ��������
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
