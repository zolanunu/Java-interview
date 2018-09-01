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
 * �������ʵ�һ�죬ţţ��С����Ƕ�������ţţȥ��԰�档 ����ţţ����ڼ��￴E3չ�������ȥ�乫԰������ţţ�ֲ���������С����ǣ�
 * ���������˹�԰�ĵ�ͼ�����ֹ�԰����һ���߳�Ϊn�������ι��ɵģ� ��԰һ����m����ڣ�������ֻ��һ����
 * ��԰����һЩ���ͽ�����ţţ������С����ǿ϶����ܴ������м䴩��������ֻ�����С� ţţ��֪������Ҫ�ߵ���̾��벢��������̾��롣
 * 
 * ��һ������һ������n(1��n��1000)��ʾ��԰�ı߳� �����������һ��n*n�Ĺ�԰��ͼ������ 
 * . ��ʾ��԰��ĵ�·��
 * @��ʾ��԰����ڣ�
 * *��ʾ��԰�ĳ��ڣ�
 * #��ʾ��԰�ڵĺ��ͽ�����
 * ţţ������С�����ÿ��ֻ�����������ƶ�һ��λ�á�
 * ���뱣֤��԰��ڸ���m(1��m��10000)�����е���ڶ��ܺͳ���������
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
	final static int[] dx = {0, 1, 0, -1}; // �ĸ��������
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
						break; // ����������
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
