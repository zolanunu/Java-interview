package com.company;

public class Pair implements Comparable<Pair> {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Pair o) {
		return x==o.x ? o.y-y:x-o.x; // yÉıĞòx½µĞò
	}
} 