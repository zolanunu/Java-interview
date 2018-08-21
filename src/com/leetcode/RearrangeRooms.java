package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class RearrangeRooms {
	/**
	 * 有n个房间，现在i号房间里的人需要被重新分配，分配的规则是这样的：先让i号房间里的人全都出来 接下来按照 i+1, i+2, i+3, ...
	 * 的顺序依此往这些房间里放一个人 n号房间的的下一个房间是1号房间，直到所有的人都被重新分配。
	 * 现在告诉你分配完后每个房间的人数以及最后一个人被分配的房间号x 你需要求出分配前每个房间的人数。数据保证一定有解，若有多解输出任意一个解。
	 * */
	public static void room(int n, int x, long[] q) {
		long round = q[0];// 圈数
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
		} // 遍历一遍所有的房间，查看当前房间人数情况，并记录最小值（当前最少房间人数的房间号）
		while (!myQueue.isEmpty()) {
			list.add(myQueue.poll());
		}
		// 人数最少房间的个数
		int size = list.size();
		// 被请出的房间的下脚标
		int tip = 0;
		// 只有一个最小值
		if (size == 1) {
			tip = list.get(0);
			// 有多个最小值,
		} else {
			// 且最后一个被分配的房间号等于最小值，则当前房间号就是被请出的房间
			if (q[x - 1] == round) {
				tip = x - 1;
			} else if (x - 1 < list.get(0) || x - 1 > list.get(size - 1)) {
				// 当最后一个被安排的房间号小于或大于所有最小值得房间号(x,2,5,7,8)(2,5,6,9,x)，则list中最靠后的那个最小值对应房间则为被请出房间
				tip = list.get(size - 1);
			} else {
				// 当最后一个被安排的房间号x位于所有最小值得房间号中间(1,3,5,x,9)，则往前最靠近的房间号为被请出的房间
				for (int i = 0; i < size; i++) {
					if (list.get(i) < x - 1 && list.get(i + 1) > x - 1) {
						tip = list.get(i);
					}
				}
			}
		}
		// 给除了被请出的那个房间的人数复原
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
		// 打印输出
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
