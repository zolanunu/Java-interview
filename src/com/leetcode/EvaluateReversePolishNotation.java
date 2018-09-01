package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
	public static int evalRpn(String[] tokens){
		if(tokens.length==0||tokens==null) {
			return 0;
		}
		if(tokens.length==1) {
			return Integer.parseInt(tokens[0]);
		}
		Deque<String> stack = new LinkedList<String>();
		stack.addFirst(tokens[0]);
		int i = 0;
		int s1 = 0;
		int s2 = 0;
		while(i<tokens.length&&!stack.isEmpty()) {
			String s = tokens[++i];
			switch (s) {
			case "+":
				s1 = Integer.parseInt(stack.pollFirst());
				s2 = Integer.parseInt(stack.pollFirst());
				System.out.println("s1 "+s1+" s2 " + s2);
				if(stack.isEmpty()&&i+1==tokens.length) {
					return s1+s2;
				} else {
					stack.addFirst(Integer.toString(s1+s2));
				}
				break;
			case "/":
				s1 = Integer.parseInt(stack.pollFirst());
				
				s2 = Integer.parseInt(stack.pollFirst());
				System.out.println("s1 "+s1+" s2 " + s2);
				if(stack.isEmpty()&&i+1==tokens.length) {
					return s2/s1;
				} else {
					stack.addFirst(Integer.toString(s2/s1));
				}
				break;
			case "*":
				s1 = Integer.parseInt(stack.pollFirst());
				s2 = Integer.parseInt(stack.pollFirst());
				System.out.println("s1 "+s1+" s2 " + s2);
				if(stack.isEmpty()&&i+1==tokens.length) {
					return s1*s2;
				} else {
					stack.addFirst(Integer.toString(s1*s2));
				}
				break;
			case "-":
				s1 = Integer.parseInt(stack.pollFirst());
				s2 = Integer.parseInt(stack.pollFirst());
				System.out.println("s1 "+s1+" s2 " + s2);
				if(stack.isEmpty()&&i+1==tokens.length) {
					return s2-s1;
				} else {
					stack.addFirst(Integer.toString(s2-s1));
				}
				break;
			default:
				stack.addFirst(s);
				break;
			}
		}
		return 0;
	}
	
	public int evalS(String[] tokens) {
		if(tokens==null||tokens.length==0) {
			return 0;
		}
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i < tokens.length; i++) {
			try {
				int num = Integer.parseInt(tokens[i]);
				stack.addFirst(num);
			} catch (Exception e) {
				// TODO: handle exception
				int b = stack.pollFirst();
				int a = stack.pollFirst();
				stack.addFirst(get(a, b, tokens[i]));
			}
		}
		return stack.pollFirst();
	}
	
	public int get(int a, int b, String oper) {
		switch (oper) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
			return a/b;
		default:
			return 0;
		}
	}
	public static void main(String[] args) {
		String[] to = {"2", "1", "+", "3", "*"};
		System.out.println(evalRpn(to));
	}
}
