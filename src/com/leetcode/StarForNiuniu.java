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
	 * Ϊ����������ѧ�����轵�����ٷ�����ѧУ��ţţ������Ϊż��������Ȼ����Ϊһ��ż�񣬿϶���Ҫ��̨���ݵġ�
	 * ��֪ţţ�õ���n����̨���ݵĻ��ᣬ��i�α��ݵ���̨ʱ��Ϊtiʱ�̣���Ҫ����mi��ô����ʱ�䡣
	 * ţţΪ������Լ���֪���ȣ��϶�Ҫȡ�������ϳ����������ʣ�ţţ������ϳ����ٴ��أ�
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
