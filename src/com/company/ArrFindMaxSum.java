package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrFindMaxSum {
	/**
	 * N*N的数组中寻找横竖左上右下，右上到左下的直线连续D个数字的和的最大的值
	 * */
	// 绝佳的解决思路
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int D = sc.nextInt();
//        int[][] nums = new int[N][N];
//        for(int i=0; i<N; i++)
//            for(int j=0; j<N; j++)
//                nums[i][j] = sc.nextInt();
//        int[][] dirs = {{1,0}, {0,1}, {1,1}, {1,-1}};
//        int max = Integer.MIN_VALUE;
//        for(int i=0; i<N; i++)
//            for(int j=0; j<N; j++) {
//                outer: for(int[] dir: dirs) {
//                    int sum = 0;
//                    for(int it=i, jt=j, k=0; k<D; k++, it+=dir[0], jt+=dir[1]){
//                        if(it<0 || it>=N || jt<0 || jt>=N) continue outer;
//                        sum += nums[it][jt];
//                    }
//                    max = Math.max(max, sum);
//                }
//            }
//        System.out.println(max);
//    }
	public static void main(String[] args) {
		// 四个方向的最大值
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int D = in.nextInt();
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int HengMax = getHengMax(arr, D);
		//System.out.println(HengMax);
		int shuMax = getShuMax(arr, D);
		int leftToRightMax = getLR(arr, D);
		int rightToLeftMax = getRL(arr, D);
		System.out.println(Math.max(Math.max(HengMax, shuMax), Math.max(leftToRightMax, rightToLeftMax)));
		in.close();
		// int hengMax = 
	}
	
	public static int getHengMax(int[][] arr, int D) {
		int len = arr.length;
		int max = 0;
		for(int i = 0; i < len; i++) {
			// 每一行計算最大值，然后看每一行的最大值
			int[] temp = arr[i];
			int maxI = getMax(temp, D);
			if(max < maxI) {
				max = maxI;
			}
		}
		return max;
	}
	
	public static int getShuMax(int[][] arr, int D) {
		int len = arr.length;
		int max = 0;
		
		for(int i = 0; i < len; i++) {
			int[] temp = new int[len];
			int j = 0;
			while(j < len) {
				temp[i] = arr[j++][i];
			}
			int maxI = getMax(temp, D);
			if(max < maxI) {
				max = maxI;
			}
			j = 0;
		}
		return max;
	}
	
	public static int getLR(int[][] arr, int D) {
		int len = arr.length;
		int max = 0;
		// 考虑三个方向
		// 中间
		for(int i = 0; i < len; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			int j = 0;
			int m = i;
			while(j < len-i && m < len-i) {
				temp.add(arr[m++][j++]);
			}
			int[] temparr = new int[temp.size()];
			for(int k = 0; k < temp.size(); k++) {
				temparr[k] = temp.get(k);
			}
			temp.clear();
			int maxI = getMax(temparr, D);
			if(max < maxI) {
				max = maxI;
			}
		}
		for(int i = 0; i < len; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			int j = 0;
			int m = i;
			while(j < len-i && m < len-i) {
				temp.add(arr[j++][m++]);
			}
			int[] temparr = new int[temp.size()];
			for(int k = 0; k < temp.size(); k++) {
				temparr[k] = temp.get(k);
			}
			temp.clear();
			int maxI = getMax(temparr, D);
			if(max < maxI) {
				max = maxI;
			}
		}
		return max;
	}
	
	public static int getRL(int[][] arr, int D) {
		int len = arr.length;
		int max = 0;
		for(int i = 0; i < len; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			int j = len-1;
			int m = i;
			while(j >= 0 && m < len) {
				temp.add(arr[m++][j--]);
			}
			int[] temparr = new int[temp.size()];
			for(int k = 0; k < temp.size(); k++) {
				temparr[k] = temp.get(k);
			}
			temp.clear();
			int maxI = getMax(temparr, D);
			if(max < maxI) {
				max = maxI;
			}
		}
		
		for(int i = len-2; i >= 0; i--) {
			ArrayList<Integer> temp = new ArrayList<>();
			int j = 0;
			int m = i;
			while(j <= len-2 && m >= 0) {
				temp.add(arr[j++][m--]);
			}
			int[] temparr = new int[temp.size()];
			for(int k = 0; k < temp.size(); k++) {
				temparr[k] = temp.get(k);
			}
			temp.clear();
			int maxI = getMax(temparr, D);
			if(max < maxI) {
				max = maxI;
			}
		}
		return max;
	}
	
	public static int getMax(int[] temp, int D) {
		if(temp.length < D) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < temp.length-D+1; i++) {
			int maxI = 0;
			for(int j = 0; i+j<temp.length&&j < D; j++) {
				maxI += temp[j+i];
			}
			if(max < maxI) {
				max = maxI;
			}
		}
		return max;
	}
}
