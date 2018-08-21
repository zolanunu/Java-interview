/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class WorldSoccer {
	/**
	 * ���籭����Ʊ
	 * 
	 * */
	
	/**
	 * ��̬�滮
	 * */
	
	 final static int maxn = 1100;
	public static void main(String[] args) {
		int[][] dp = new int[maxn][maxn];
		int[] weight = new int[maxn]; // ���ײͼ۸�
		int[] value = new int[maxn]; // ���ײ��ṩƱ��
		
		int n, m, k;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt(); // ����
		m = in.nextInt(); // �ײ���
		k = in.nextInt(); // ����Ʊ��
		n = n + 1;
		for(int i = 1; i <= m; i++) {
			
			weight[i] = in.nextInt();
			value[i] = in.nextInt(); 
		}
		
//		for(int i = 1; i <= m; i++) {
//			System.out.print(weight[i]);
//			//System.out.println(value[i]);
//		}
//		System.out.println();
//		for(int i = 1; i <= m; i++) {
//			//System.out.print(weight[i]);
//			System.out.print(value[i]);
//		}
		for(int i = 1; i <= n; i++) {
			dp[0][i] = i * k;
			
			
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(j > value[i]) {// ��ǰ���������ײ����ṩ��Ʊ��
					dp[i][j] = Math.min(dp[i-1][j],  dp[i-1][j-value[i]] + weight[i]);
					// ʹ�õ�ǰ�۸�Ͳ����õ�ǰ�۸�ıȽ�
				} else {
					dp[i][j] = Math.min(dp[i-1][j], weight[i]); // ������С�ڵ����ײ��е��ṩƱ����ʱ��������������ú�ʹ��
				}
			}
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[m][n]);
	}
}
