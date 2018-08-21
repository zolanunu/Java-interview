package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PushBox2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		char[][] map = new char[N + 2][M + 2];
		boolean[][] used = new boolean[N + 2][M + 2];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], '#');
		}

		int[] start = null;
		int[] end = null;
		int[] box = null;
		for (int i = 1; i < map.length - 1; i++) {
			int j = 1;
			for (char ch : scan.next().toCharArray()) {
				map[i][j] = ch;
				if (ch == 'X') {
					start = new int[] { i, j };
				}
				if (ch == '@') {
					end = new int[] { i, j };
				}
				if (ch == '*') {
					box = new int[] { i, j };
				}
				j++;
			}
		}
		int res = findWay(map, used, start, end, box, 0);
		System.out.println(res);
		scan.close();
	}

	private static int findWay(char[][] map, boolean[][] used, int[] start, int[] end, int[] box, int wayLen) {
		if (box[0] == end[0] && box[1] == end[1]) {
			return wayLen;
		} else {
			int res = Integer.MAX_VALUE;
			int[] curbox = box.clone();
			int[][] dirs = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };// left, up, right, down;
			for (int[] dir : dirs) {
				int[] next = new int[] { start[0] + dir[0], start[1] + dir[1] };
				if (used[next[0]][next[1]] || map[next[0]][next[1]] == '#') {
					continue;
				}
				if (next[0] == box[0] && next[1] == box[1]) {
					curbox = new int[] { box[0] + dir[0], box[1] + dir[1] };
					if (used[curbox[0]][curbox[1]] || map[curbox[0]][curbox[1]] == '#') {
						continue;
					}
				}

				used[next[0]][next[1]] = true;
				// System.out.println("next: "+Arrays.toString(next));
				int curLen = findWay(map, used, next, end, curbox, wayLen + 1);
				used[next[0]][next[1]] = false;

				res = curLen == -1 ? res : Math.min(res, curLen);
			}
			return res == Integer.MAX_VALUE ? -1 : res;
		}
	}
}
