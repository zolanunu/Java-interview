/**
 * 
 */
package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zolanunu
 * 
 */
public class SessionList {
	/**
	 * 会话列表
	 * https://blog.csdn.net/RaAlGhul/article/details/81387300
	 * */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();
		Set<Integer> sets = new HashSet<>();

		while (n-- > 0) {
			int m = in.nextInt();
			// int[] list = new int[m];
			// int[][] map = new int[m][2];
			int[] id = new int[m];
			sets.clear();
			for (int i = 0; i < m; i++) {
				id[i] = in.nextInt();
			}
			int[] ans = new int[m + 1];
			int num = 0;
			for (int i = m - 1; i >= 0; i--) {
				if (sets.contains(id[i])) {
					continue;
				} else {
					sets.add(id[i]);
					ans[num++] = id[i];
				}
			}
			// Integer[] ans = (Integer[]) sets.toArray();
			for (int i = 0; i < num; i++) {
				if (i == num - 1) {
					System.out.print(ans[i]);
				} else {
					System.out.print(ans[i] + " ");
				}
			}

		}

		in.close();
	}
}
