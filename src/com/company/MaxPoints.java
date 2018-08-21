package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxPoints {
	/**
	 * ����c����
	 * �ڸ����Ķ�άƽ���ϣ�x����P������㶼����x�����Ϸ�������
	 * �������궼������x
	 * */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Pair[] arr = new Pair[n];
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			arr[i] = new Pair(x, y);
		}
		Arrays.sort(arr);
		java.util.List<Pair> res = new ArrayList<Pair>();
		for(int i = 0; i < n; i++) {
			boolean f = true;
			for(int j = 0; i != j && j < n; j++) {
				if(arr[i].x < arr[j].x && arr[i].y < arr[j].y) {
					f = false;
					break;
				}
			}
			if(f) {
				res.add(arr[i]);
			}
		}
		//res.forEach(Pair o)->System.out.println(o.x+" " +o.y);
		for(int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).x + " " + res.get(i).y);
		}
		in.close();
	}
}
