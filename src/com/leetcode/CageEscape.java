package com.java.leetcode.coding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class CageEscape {
	/**
	 * 地牢逃脱
	 * 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，
	 * 遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，
	 * 要求每一步都不可以超过地牢的边界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。
	 * 牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
	 * 瞬间移动，即不管中间是否有障碍物，只要目标位置不是障碍物
	 * */
	
	/***
	 * 输入样例
	 * 3 3 (n,m)
	 * ... (地牢)
	 * ...
	 * ...
	 * 0 1 (出发位置)
	 * 4 之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数
	 * 1 0 接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50
	 * 0 1
	 * -1 0
	 * 0 -1
	 * */
	int n,m;
	int[][] direction= new int[55][2];
	int dcnt;
	int[][] ground = new int[55][55]; // 2 表示. 3表示X
	int[][] dis = new int[55][55];
	public CageEscapePoint go(CageEscapePoint x, int idx, int[][] direction) {
		CageEscapePoint re = new CageEscapePoint(x.getX()+direction[idx][0], x.getY()+direction[idx][1]);
		return re;
	}
	public boolean isOk(CageEscapePoint y) {
		return (y.getX()>=0 && y.getX()<n) && (y.getY()>=0&&y.getY()<m) && (ground[y.getX()][y.getY()]==2);
	}
	public int maxSolution() {
		System.out.println("hello,,,in Solution");
		
		System.out.println("whiy");
		Scanner inScanner = new Scanner(System.in);
		n = inScanner.nextInt();
		m = inScanner.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dis[i][j] = Integer.MAX_VALUE;
				
				System.out.print(dis[i][j]);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				ground[i][j] = inScanner.nextInt();
			}
		}
		
		int x = inScanner.nextInt();
		int y = inScanner.nextInt();
		CageEscapePoint start = new CageEscapePoint(x, y);
		
		dcnt = inScanner.nextInt();
		
		for(int i = 0; i < dcnt; i++) {
			for(int j = 0; j < 2; j++) {
				direction[i][j] = inScanner.nextInt(); 
			}
		}
		
		// 到此基本的输入完成
		
		dis[start.getX()][start.getY()] = 0;
		Queue<CageEscapePoint> pointQueue = new LinkedList<CageEscapePoint>();
		pointQueue.add(start);
		while(!pointQueue.isEmpty()) {
			CageEscapePoint xCageEscapePoint = pointQueue.remove();
			for(int i = 0; i < dcnt; i++) {
				CageEscapePoint yCageEscapePoint = go(xCageEscapePoint, i, direction);
				if(isOk(yCageEscapePoint)) {
					if(dis[yCageEscapePoint.getX()][yCageEscapePoint.getY()] > dis[xCageEscapePoint.getX()][xCageEscapePoint.getY()]+1) {
						dis[yCageEscapePoint.getX()][yCageEscapePoint.getY()] = dis[xCageEscapePoint.getX()][xCageEscapePoint.getY()] + 1;
						pointQueue.add(yCageEscapePoint);
					}
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(ground[i][j] == 2) {
					answer = Math.max(answer, dis[i][j]);
				}
				System.out.print(dis[i][j]);
			}
			System.out.println();
		}
		
		return answer;
	}
	public static void main(String[] args) {
		CageEscape cEscape = new CageEscape();
		System.out.println(cEscape.maxSolution());
	}
}
