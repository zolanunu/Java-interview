package com.java.leetcode.coding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class CageEscape {
	/**
	 * ��������
	 * ����һ�� n �� m �еĵ��Σ����� '.' ��ʾ����ͨ�е�λ�ã�'X' ��ʾ����ͨ�е��ϰ���ţţ�� (x0 , y0 ) λ�ó�����
	 * ����������Σ���һ�����Ϸ����ͬ���ǣ���ÿһ��ֻ�ܰ���һЩָ���Ĳ����������Σ�
	 * Ҫ��ÿһ���������Գ������εı߽磬Ҳ���ܵ����ϰ��ϡ����εĳ��ڿ���������ĳ������ͨ�е�λ���ϡ�
	 * ţţ��֪�������£�����Ҫ���ٲ��ſ����뿪������Ρ�
	 * ˲���ƶ����������м��Ƿ����ϰ��ֻҪĿ��λ�ò����ϰ���
	 * */
	
	/***
	 * ��������
	 * 3 3 (n,m)
	 * ... (����)
	 * ...
	 * ...
	 * 0 1 (����λ��)
	 * 4 ֮���һ�а���һ������ k��0 < k <= 50����ʾţţ�Ϸ��Ĳ�����
	 * 1 0 �������� k �У�ÿ���������� dx, dy ��ʾÿ�ο�ѡ���ƶ����к��в�����-50 <= dx, dy <= 50
	 * 0 1
	 * -1 0
	 * 0 -1
	 * */
	int n,m;
	int[][] direction= new int[55][2];
	int dcnt;
	int[][] ground = new int[55][55]; // 2 ��ʾ. 3��ʾX
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
		
		// ���˻������������
		
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
