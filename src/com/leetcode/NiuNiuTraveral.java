/**
 * 
 */
package com.leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zolanunu
 *
 */

/**
 * 又是晴朗的一天，牛牛的小伙伴们都跑来找牛牛去公园玩。 但是牛牛想呆在家里看E3展，不想出去逛公园，可是牛牛又不想鸽掉他的小伙伴们，
 * 于是找来了公园的地图，发现公园是由一个边长为n的正方形构成的， 公园一共有m个入口，但出口只有一个。
 * 公园内有一些湖和建筑，牛牛和他的小伙伴们肯定不能从他们中间穿过，所以只能绕行。 牛牛想知道他需要走的最短距离并输出这个最短距离。
 * 
 * 第一行输入一个数字n(1≤n≤1000)表示公园的边长 接下来会给你一个n*n的公园地图，其中 
 * . 表示公园里的道路，
 * @表示公园的入口，
 * *表示公园的出口，
 * #表示公园内的湖和建筑。
 * 牛牛和他的小伙伴们每次只能上下左右移动一格位置。
 * 输入保证公园入口个数m(1≤m≤10000)且所有的入口都能和出口相连。
 * */
public class NiuNiuTraveral {
	static class  Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
	}

	final static int maxn = 1300;
	final static int[] dx = {0, 1, 0, -1}; // 四个方向遍历
	final static int[] dy = {-1, 0, 1, 0};

	

	public static int findMinDis(int n, int m, char[][] mp, int[][] dis) {
		Node aNode = null;
		Node ed = null;
		Queue<Node> q = new LinkedList<NiuNiuTraveral.Node>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(mp[i][j] == '@') {
					aNode = new NiuNiuTraveral.Node(i, j);
					q.add(aNode);
					dis[i][j] = 0;
				}
				if(mp[i][j] == '*') {
					ed = new Node(i, j);
				}
			}
		}
		while(!q.isEmpty()){
			Node p = q.peek();
			q.poll();
			for(int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				// System.out.println("px="+px+"py="+py);
				if(px >= 0 && px < n && py >= 0 && py < n && mp[px][py] != '#' && dis[px][py] == -1) {
					Node ppNode = null;
					ppNode = new Node(px, py);
					q.add(ppNode);
					dis[px][py] = dis[p.x][p.y] + 1;
					if(px == ed.getX() && py == ed.getY()) {
						break; // 遇到出口了
					}
				}
			}
			if(dis[ed.x][ed.y] != -1) {
				break;
			}
		}
		// System.out.println(dis[ed.x][ed.y]);
		return dis[ed.x][ed.y];
	}
	public static void main(String[] args) {
		
		int[][] dis = new int[maxn][maxn];
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		int m = inScanner.nextInt();
		char[][] mp = new char[n][n];
		for(int i = 0; i < n; i++) {
			String s = inScanner.next();
			for(int j = 0; j < n; j++) {
				mp[i][j] = s.charAt(j);
			}
		}
		inScanner.close();
		for(int i = 0; i < maxn; i++) {
			for(int j = 0; j < maxn; j++) {
				dis[i][j] = -1;
			}
		}
		int result = findMinDis(n, m, mp, dis);
		System.out.println(result);
	}
}
