package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.DocFlavor.STRING;


public class PushBox {
	/**
	 * 给你一个矩阵，里面有‘#’，表示障碍，‘.’表示空地，‘S’表示人开始的位置，‘E’表示箱子的预期位置，‘0’表示箱子的初始位置，你的任务是把箱子从‘0’推到‘E’.
	 * 注意不能将箱子推到‘#’上，也不能将箱子推出边界；
	 * 现在给你游戏的初始样子，你需要输出最少几步能够完成游戏，如果不能完成，则输出-1.
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
