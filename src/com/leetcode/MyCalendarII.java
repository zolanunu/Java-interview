package com.leetcode;


import java.util.Set;

public class MyCalendarII {
	
	private static Set<Pair> s1, s2;
	// s2 是s1的所有交集部分
	/***/
	public MyCalendarII() {
		// TODO Auto-generated constructor stub
	}
	public static boolean book(int s, int e) {
		for (Pair set : s2) { // 查看是否和s2有交集
			if (s >= set.getE() || e <= set.getS()) {
				// 没有任何交集，先走了或者后来来的
				continue;
			}
			else {
				// 有交集
				return false;
			}
		}
		for (Pair a : s1) {
            if (s >= a.getE() || e <= a.getS()){
            	continue;
            }
            else{
            	s2.add(new Pair(Math.max(s, a.getS()), Math.min(e, a.getE())));//将交集部分加入
            }
        }
		s1.add(new Pair(s, e));
		return true;
	}
	
}
