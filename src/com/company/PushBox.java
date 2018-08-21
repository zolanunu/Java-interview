package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Stage {
	int peoplex;
	int peopley;
	int boxx;
	int boxy;
	Stage previous;

	public boolean equals(Object obj) {
		if (obj instanceof Stage) {
			if (((Stage) obj).peoplex == peoplex && ((Stage) obj).peopley == peopley && ((Stage) obj).boxx == boxx
					&& ((Stage) obj).boxy == boxy)
				return true;
		}
		return false;
	}

	public Stage() {

	}

	public Stage(int peoplex, int peopley, int boxx, int boxy) {
		this.peoplex = peoplex;
		this.peopley = peopley;
		this.boxx = boxx;
		this.boxy = boxy;
	}
	
	public Stage(int peoplex, int peopley) {
		super();
		this.peoplex = peoplex;
		this.peopley = peopley;
	}

	@Override
	public String toString() {
		return "Stage [ peoplex = " + peoplex + ", peopley = " + peopley + ", boxx = " + boxx + ", boxy = " + boxy
				+ "]";
	}

}

public class PushBox {
	/**
	 * 网易笔试：推箱子 N*M地图，玩家，箱子，目的地，若干障碍物，其余是空地，四个方向移动，求最少需要移动多少步，目标达成
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = in.next().toCharArray();
		}
		int peopleX = 0;
		int peopleY = 0;
		int boxX = 0;
		int boxY = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'X') {
					peopleX = i;
					peopleY = j;
				}
				if(map[i][j] == '*') {
					boxX = i;
					boxY = j;
				}
			}
		}
		
		Stage begin = new Stage(peopleX, peopleY, boxX, boxY);
		System.out.println(begin);
		Stage result = BFS(begin, map, N, M);
		if(result == null) {
			System.out.println(-1);
		} else {
			while(result.previous != null) {
				System.out.println(result.previous);
				result = result.previous;
			}
		}
		in.close();
	}
	
	public static Stage BFS(Stage peopleBegin, char[][] map, int N, int M) {
		Queue<Stage> queue = new LinkedList<Stage>();
		ArrayList<Stage> list = new ArrayList<Stage>();
		int[][] dr = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
		queue.offer(peopleBegin);
		while(!queue.isEmpty()) {
			Stage local = queue.remove();
			list.add(local);
			// 开始四个方向搜索
			for(int i = 0; i < dr.length; i++) {
				Stage next = new Stage(local.peoplex+dr[i][0], local.peopley+dr[i][1]);
				next.previous = local;
				if(next.peoplex>=0 && next.peoplex<N&&next.peopley>=0&&next.peopley<M &&map[next.peoplex][next.peopley] != '#') {
					if(next.peoplex==local.boxx&&next.peopley==local.boxy) {
						next.boxx = local.boxx + dr[i][0];
						next.boxy = local.boxy + dr[i][1];
					} else {
						next.boxx = local.boxx;
						next.boxy = local.boxy;
					}
					if(list.contains(next)) {
						continue;
					}
					if(next.boxx>=0&&next.boxx<N&&next.boxy>=0&&next.boxy<M &&map[next.boxx][next.boxy] !='#') {
						list.add(next);
						queue.offer(next);
					} else {
						continue;
					}
					if(map[next.boxx][next.boxy] == '@') {
						return next;
					}
				}
			}
		}
		return null;
	}
 }
