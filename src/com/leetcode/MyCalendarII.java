package com.leetcode;


import java.util.Set;

public class MyCalendarII {
	
	private static Set<Pair> s1, s2;
	// s2 ��s1�����н�������
	/***/
	public MyCalendarII() {
		// TODO Auto-generated constructor stub
	}
	public static boolean book(int s, int e) {
		for (Pair set : s2) { // �鿴�Ƿ��s2�н���
			if (s >= set.getE() || e <= set.getS()) {
				// û���κν����������˻��ߺ�������
				continue;
			}
			else {
				// �н���
				return false;
			}
		}
		for (Pair a : s1) {
            if (s >= a.getE() || e <= a.getS()){
            	continue;
            }
            else{
            	s2.add(new Pair(Math.max(s, a.getS()), Math.min(e, a.getE())));//���������ּ���
            }
        }
		s1.add(new Pair(s, e));
		return true;
	}
	
}
