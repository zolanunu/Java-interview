package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RefreshCard {
	/**
	 * 2n张牌，按照一定的规则进行洗牌
	 * 洗k次以后
	 * 
	 * */
	public static ArrayList<Integer> refreshCard(int[] cards) {
		System.out.println(cards.length);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> resultArrayList = new ArrayList<>();
		for(int i = cards.length/2-1, j= cards.length-1; i >= 0 && j >= cards.length / 2; i--, j--) {
			System.out.println("i = " + i + " j = " + j);
			queue.addFirst(cards[j]);
			queue.addFirst(cards[i]);
		}
		queue.clear();
		resultArrayList.clear();
		while(!queue.isEmpty()) {
			//System.out.println(queue.removeFirst());
			resultArrayList.add(queue.removeFirst());
		}
		System.out.println(resultArrayList.size());
		return resultArrayList;
	}
	public static void main(String[] args) {
		//int[] cards = {1,2,3,4,5,6};
		Scanner inScanner = new Scanner(System.in);
		int groups = inScanner.nextInt();
		while(groups-- > 0) {
			int n = inScanner.nextInt(); // n
			int k = inScanner.nextInt(); // 洗牌次数k
			int[] res = new int[2*n];
			for(int i = 0; i < 2*n; i++) {
				//int temp = i + 1;
				res[i] = inScanner.nextInt();
			}
			ArrayList<Integer> resArrayList = new ArrayList<Integer>();
			for(int i = 0; i < k; i++) {
				resArrayList = refreshCard(res);
			}
			System.out.print(resArrayList.get(0));
			for(int i = 1; i < 2*n; i++) {
				System.out.print(" " + resArrayList.get(i));
			}
			// int i = resArrayList.size();
			System.out.println();
		}
		
		
	}
}
