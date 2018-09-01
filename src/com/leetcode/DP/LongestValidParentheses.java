package com.leetcode.DP;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
	/**
	 * 最长有效的括号
	 * http://bangbingsyb.blogspot.com/2014/11/leetcode-longest-valid-parentheses.html
	 * */
	public static int longestValidPa(String s) {
		if(s.length()<=1||s==null) {
			return 0;
		}
		Deque<Integer> stack = new LinkedList<Integer>();
		int res = 0;
		int start = 0;
		char[] string = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			//System.out.println(s);
			if(string[i]=='(') {
				stack.addFirst(i);
			} else if(string[i]==')') {
				if(stack.isEmpty()) {
					start = i + 1;
				} else {
					stack.removeFirst();
					System.out.println("start = " + start + "i = " + i);
					res = stack.isEmpty() ? Math.max(res, i-start+1) :  Math.max(res, i - stack.peekFirst());
				}
			}
			System.out.println("start = " + start + "i = " + i);
		}
		return res;
	}
	public static void main(String[] args) {
		String string = "(()";
		System.out.println(longestValidPa(string));
	}
}
