package com.java.leetcode.coding;

import java.util.ArrayList;


public class MyCalendarI {
	public MyCalendarI() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<int[]> pair;
	
	public boolean book(int start, int end) {
		for(int i = 0; i < pair.size(); i++) {
			if(pair.get(i)[0] <= start && pair.get(i)[1] > start) {
				return false;
			}
			if (pair.get(i)[0] > start && pair.get(i)[0] < end) {
				return false;
			}
		}
		int[] a = {start, end};
		pair.add(a);
		return true;
	}
}
