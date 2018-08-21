package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxPoints {
	/**
	 * 最大點集合
	 * 在给定的二维平面上，x满足P中任意点都不在x的右上方区域内
	 * 横纵坐标都不大于x
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
