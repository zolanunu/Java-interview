/**
 * 
 */
package com.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zolanunu
 * 
 */
public class OulaCirCle {
	/***
	 * ŷ����·���� N (�ڵ���) M (����) s -> e
	 * 3 3
	 * 1 2
	 * 1 3
	 * 2 3
	 * 0
	 * 1
	 * */

	public static int MAX = 1000;
	public static int[][] map = new int[MAX][MAX]; // ����ͼ
	public static ArrayList<Integer> result = new ArrayList<Integer>(); // ���ڴ������������

	// �жϸ���ͼ��ÿ������Ķ��Ƿ��Ϊż��
	public boolean judge(int[] degree) {
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] % 2 != 0)
				return false;
		}
		return true;
	}

	// ʹ��BFS�������жϸ���ͼ�Ƿ�Ϊ��ͨͼ
	public boolean bfs(int n) {
		boolean[] used = new boolean[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		used[0] = true;
		while (!list.isEmpty()) {
			int temp = list.get(0);
			list.remove(0);
			for (int i = 0; i < n; i++) {
				if (!used[i] && map[temp][i] != 0) {
					used[i] = true;
					list.add(i);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (used[i] == false)
				return false;
		}
		return true;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		OulaCirCle test = new OulaCirCle();
		Scanner in = new Scanner(System.in);
		while (true) {
			int n = in.nextInt(); // ����ͼ�Ķ�����
			if (n == 0)
				break;
			int m = in.nextInt(); // ����ͼ�ı���Ŀ
			int[] degree = new int[n]; // ���ڼ�������ͼ��ÿ������Ķ�
			for (int i = 0; i < m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				map[a - 1][b - 1] = 1;
				map[b - 1][a - 1] = 1;
				degree[a - 1]++;
				degree[b - 1]++;
			}
			if (test.judge(degree) && test.bfs(n))
				result.add(1);
			else
				result.add(0);
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
