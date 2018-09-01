package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.DocFlavor.STRING;


public class PushBox {
	/**
	 * ����һ�����������С�#������ʾ�ϰ�����.����ʾ�յأ���S����ʾ�˿�ʼ��λ�ã���E����ʾ���ӵ�Ԥ��λ�ã���0����ʾ���ӵĳ�ʼλ�ã���������ǰ����Ӵӡ�0���Ƶ���E��.
	 * ע�ⲻ�ܽ������Ƶ���#���ϣ�Ҳ���ܽ������Ƴ��߽磻
	 * ���ڸ�����Ϸ�ĳ�ʼ���ӣ�����Ҫ������ټ����ܹ������Ϸ�����������ɣ������-1.
	 * */
	int[] dirx = {-1, 0, 1, 0};
	int[] diry = {0, 1, 0, -1};
	int n, m;
	class Point {
		int x;
		int y;
		Point() {
			x = 0;
			y = 0;
		}
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public boolean isSame(Point m) {
			return m.x == this.x && m.y == this.y; 
		}
	}
	
	class Node {
		Point peo, boxPoint;
		int step;
		Node() {
			
		}
		Node(Point peo, Point boxPoint, int step) {
			this.peo.x = peo.x;
			this.peo.y = peo.y;
			this.boxPoint.x = boxPoint.x;
			this.boxPoint.y = boxPoint.y;
			this.step = step;
		}
		public boolean stepfor(Node other) {
			return this.step > other.step;
		}
	}
	class Peo {
	    Point point;
	    int step;
	    Peo() {}
	    Peo(Point point, int step) {
	    	this.point.x = point.x;
	    	this.point.y = point.y;
	    	this.step = step;
	    }
	}
	public boolean check(int x, int y) {return (x >= 0 && x < n && y >= 0 && y < m);
	}
	
	public int bfs(Point src, Point des, Point box, char[][] map) {
	    Queue<Point> que = new LinkedList<>();
	    boolean[][] isvisited = new boolean[n][m];
	    que.add(src);
	    isvisited[src.x][src.y] = true;
	    int ret = -1;
	    while (!que.isEmpty()) {
	        Point now = que.peek();
	        
	        if (now.x== des.x && now.y==des.y) {
	            
	            break;
	        }
	        for (int k = 0; k < 4; k++) {
	            int tx = now.x + dirx[k];
	            int ty = now.y + diry[k];
	            if (check(tx, ty) && map[tx][ty] == '.' && !(tx== box.x&&ty==box.y) && !isvisited[tx][ty]) {
	            	Point point = new Point(tx, ty);
	            	que.add(point);
	            	ret+=1;
	            	isvisited[tx][ty] = true;
	            }
	            
	        }
	    }
	    return ret;
	}
	public static void main(String[] args) {
		
	}
}
