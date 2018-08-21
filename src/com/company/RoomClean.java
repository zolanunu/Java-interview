package com.company;

import java.util.Scanner;
/**
 * 第一行一个数n(1 <= n <= 100)，表示杂物的团数。
 * 接下来4n行，每4行表示一团杂物，每行4个数ai, bi，xi, yi, (-104 <= xi, yi, ai, bi <= 104)
 * 表示第i个物品旋转的它本身的坐标和中心点坐标。
 * 
 * n行，每行1个数，表示最少移动次数。
 * */
public class RoomClean {
	public void readIn() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(dealOne(sc));
		}
	}

	private int dealOne(Scanner sc) {
		int[] a = new int[4];
		Point[] ps = new Point[4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				a[j] = sc.nextInt();
			}
			ps[i] = new Point(a);
		}
		return getMinStep(ps);

	}

	private int getMinStep(Point[] ps) {
		int times = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			int[] s = new int[4];
			s[0] = (i & 0b11000000) >> 6;
			s[1] = (i & 0b110000) >> 4;
			s[2] = (i & 0b1100) >> 2;
			s[3] = i & 0b11;
			testRotate(ps, s);
			if (check(ps)) {
				int sum = s[0] + s[1] + s[2] + s[3];
				times = (sum < times) ? sum : times;
			}
			recover(ps, s);

		}
		if (times == Integer.MAX_VALUE)
			return -1;
		else
			return times;

	}

	private void testRotate(Point[] ps, int[] s) {
		for (int i = 0; i < 4; i++) {
			ps[i].rotate(s[i]);
		}

	}

	private void recover(Point[] ps, int[] s) {
		for (int i = 0; i < 4; i++) {
			ps[i].rotateReverse(s[i]);

		}

	}

	private boolean check(Point[] ps) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; (j < 4) && (j != i); j++) {
				if (ps[i].distance2(ps[j]) == 0)
					return false;

			}

		}
		long[] d = new long[3];
		d[0] = ps[2].distance2(ps[1]);
		d[1] = ps[0].distance2(ps[2]);
		d[2] = ps[1].distance2(ps[0]);
		int maxIndex = 0;
		long sum = d[0] + d[1] + d[2];
		for (int i = 0; i < 3; i++) {
			if (2 * d[i] == sum) {
				maxIndex = i;
				break;
			}
			if (i == 2)
				return false;
		}
		int n1 = (maxIndex + 1) % 3;
		int n2 = (maxIndex + 2) % 3;
		if (d[n1] != d[n2])
			return false;
		if (ps[maxIndex].distance2(ps[3]) != sum / 2)
			return false;
		if (ps[n1].distance2(ps[3]) != ps[n2].distance2(ps[3]))
			return false;
		return true;

	}

	class Point {
		int a, b, x, y;

		public Point(int[] s) {
			a = s[0];
			b = s[1];
			x = s[2];
			y = s[3];
		}

		public void rotate(int i) {
			if (i == 0) {
				return;
			} else if (i == 1) {
				rotate90();
			} else if (i == 2) {
				rotate180();
			} else {
				rotate270();
			}
		}

		public void rotateReverse(int i) {
			rotate((4 - i) % 4);
		}

		public void rotate90() {
			int swap = a;
			a = y - b + x;
			b = swap - x + y;
		}

		public void rotate180() {
			a = x * 2 - a;
			b = y * 2 - b;
		}

		public void rotate270() {
			int swap = a;
			a = b - y + x;
			b = x - swap + y;
		}

		public long distance2(Point p) {
			long q1 = this.a - p.a;
			long q2 = this.b - p.b;
			return q1 * q1 + q2 * q2;
		}
	}

	public static void main(String[] args) {
		new RoomClean().readIn();
	}
}
