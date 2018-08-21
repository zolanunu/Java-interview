package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class RearrangeRooms {
	/**
	 * ��n�����䣬����i�ŷ����������Ҫ�����·��䣬����Ĺ����������ģ�����i�ŷ��������ȫ������ ���������� i+1, i+2, i+3, ...
	 * ��˳����������Щ�������һ���� n�ŷ���ĵ���һ��������1�ŷ��䣬ֱ�����е��˶������·��䡣
	 * ���ڸ�����������ÿ������������Լ����һ���˱�����ķ����x ����Ҫ�������ǰÿ����������������ݱ�֤һ���н⣬���ж���������һ���⡣
	 * */
	public static void room(int n, int x, long[] q) {
		long round = q[0];// Ȧ��
		Queue<Integer> myQueue = new LinkedBlockingQueue<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		myQueue.add(0);
		for (int i = 1; i < n; i++) {
			if (round > q[i]) {
				round = q[i];
				while (!myQueue.isEmpty()) {
					myQueue.poll();
				}
				myQueue.add(i);
			} else if (round == q[i]) {
				myQueue.add(i);
			}
		} // ����һ�����еķ��䣬�鿴��ǰ�����������������¼��Сֵ����ǰ���ٷ��������ķ���ţ�
		while (!myQueue.isEmpty()) {
			list.add(myQueue.poll());
		}
		// �������ٷ���ĸ���
		int size = list.size();
		// ������ķ�����½ű�
		int tip = 0;
		// ֻ��һ����Сֵ
		if (size == 1) {
			tip = list.get(0);
			// �ж����Сֵ,
		} else {
			// �����һ��������ķ���ŵ�����Сֵ����ǰ����ž��Ǳ�����ķ���
			if (q[x - 1] == round) {
				tip = x - 1;
			} else if (x - 1 < list.get(0) || x - 1 > list.get(size - 1)) {
				// �����һ�������ŵķ����С�ڻ����������Сֵ�÷����(x,2,5,7,8)(2,5,6,9,x)����list�������Ǹ���Сֵ��Ӧ������Ϊ���������
				tip = list.get(size - 1);
			} else {
				// �����һ�������ŵķ����xλ��������Сֵ�÷�����м�(1,3,5,x,9)������ǰ����ķ����Ϊ������ķ���
				for (int i = 0; i < size; i++) {
					if (list.get(i) < x - 1 && list.get(i + 1) > x - 1) {
						tip = list.get(i);
					}
				}
			}
		}
		// �����˱�������Ǹ������������ԭ
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (i != tip) {
				if (x - 1 > tip) {
					if (i > tip && i <= x - 1) {
						q[i] = q[i] - round - 1;
						sum = sum + (round + 1);
					} else {
						q[i] = q[i] - round;
						sum = sum + round;
					}
				} else if (x - 1 < tip) {
					if ((i >= 0 && i <= x - 1) || (i > tip && i < n)) {
						q[i] = q[i] - round - 1;
						sum = sum + (round + 1);
					} else {
						q[i] = q[i] - round;
						sum = sum + round;
					}
				} else {
					q[i] = q[i] - round;
					sum = sum + round;
				}
			}
		}
		q[tip] = sum + round;
		// ��ӡ���
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.println(q[i]);
			} else {
				System.out.print(q[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		long[] q = new long[n];
		for (int i = 0; i < n; i++) {
			q[i] = scan.nextInt();
		}
		room(n, x, q);
	}
}
