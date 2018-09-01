/**
 * 
 */
package com.leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author zolanunu
 * 
 */
public class StarForNiuniu {
	/**
	 * 为了拯救因入学人数骤降，面临废弃的学校，牛牛决定成为偶像啦。当然，作为一个偶像，肯定是要上台表演的。
	 * 已知牛牛拿到了n个上台表演的机会，第i次表演的上台时间为ti时刻，需要表演mi这么长的时间。
	 * 牛牛为了提高自己的知名度，肯定要取得最多的上场次数。请问，牛牛最多能上场多少次呢？
	 * */

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[][] list = new int[m][2];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < 2; j++) {
				list[i][j] = sc.nextInt();
				
			}
			list[i][1] = list[i][0] + list[i][1];
		}
		
		for(int i = 0; i < m ; i++) {
			if(list[i][1] > list[i+1][1]) {
				
			}
		}
		
		
		
		
//		while (sc.hasNext()) {
//			int num = sc.nextInt();
//			int[][] list = new int[][];
//			for (int i = 0; i < num; i++) {
//				int start = sc.nextInt();
//				int end = start + sc.nextInt();
//				
//			}
//			Collections.sort(list, new Comparator() {
//				public int compare(int[] o1, int[] o2) {
//					if (o1[1] != o2[1]) {
//						return o1[1] - o2[1];
//					} else {
//						return o1[0] - o2[0];
//					}
//				}
//			});
//			int count = 1;
//			int start = list.get(0)[0];
//			int end = list.get(0)[1];
//			for (int i = 1; i < list.size(); i++) {
//				int[] cur = list.get(i);
//				if (cur[0] >= end) {
//					count++;
//					end = cur[1];
//				}
//			}
//			System.out.println(count);
//		}
		sc.close();
	}
}
