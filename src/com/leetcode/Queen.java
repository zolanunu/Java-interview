/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Stack;

/**
 * @author zolanunu
 * 
 */
public class Queen {

	public int x, y;

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Queen(Queen q) {
		x = q.x;
		y = q.y;
	}

	@Override
	public boolean equals(Object obj) {
		Queen o = (Queen) obj;
		return x == o.x || y == o.y || x + y == o.x + o.y || x - y == o.x - o.y;
	}

	static void placeQueens(final int N) {
		int nsolus = 0;
		Stack<Queen> solus = new Stack<Queen>();
		Queen q = new Queen(0, 0);
		do {
			if (q.y >= N || solus.size() >= N) {// ���磬�����
				q = new Queen(solus.pop());
				q.y++;
			} else {
				while (q.y < N && (solus.contains(q)))
					// �ӵ�0�п�ʼ����Ѱ�ҷ���������λ��
					q.y++;
				if (q.y < N) {// �ҵ�һ����ѡ��λ��
					solus.push(q);
					if (solus.size() >= N)
						nsolus++;
					q = new Queen(q.x + 1, 0);
				}

			}
		} while (q.x > 0 || q.y < N);

		System.out.printf("There are %d solutions for %d queens\n", nsolus, N);
	}
	public static void change(String s) {
		s = "cd";
	}
	public static void main(String[] args) {
		//placeQueens(Integer.valueOf(args[0]));
		String x = new String("abs");
		change(x);
		short s = (short) 80000;
		System.out.println(s);
		System.out.println(x);
	}
}
