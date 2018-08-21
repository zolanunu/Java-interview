package com.java.leetcode.coding;

import java.util.Stack;

public class MinStack {
	/**
	 * 构造一个包含取最小元素的函数的栈数据结构
	 * */
	/**
	 * 一种解决办法是：利用其他辅助空间
	 * */
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minIntegers = new Stack<>();
	public void push(int node) {
		stack.push(node);
		if(minIntegers.empty()) {//最小值栈为空
			minIntegers.add(node);
		} else {
			// 不为空的情况
			if(node < minIntegers.peek().intValue()) {
				minIntegers.push(node); // 当前需要压入栈的元素更小，保存
			} else {
				minIntegers.push(minIntegers.peek()); // 如果不是,minStacks和Stack的数量保持一致
			}
		}
	}
	
	public void pop() {
		if(!stack.empty()) {// 非空的话，直接弹出最顶元素就好
			stack.pop();
		}
		if(!minIntegers.empty()) {
			minIntegers.pop();
		}
	}
	
	public int top() {
		if(!stack.empty()) {
			return stack.peek().intValue();
		} else {
			return 0;
		}
	}
	
	public int min() {
		if(!minIntegers.empty()) {
			return minIntegers.peek().intValue();
		} else {
			return 0;
		}
	}
}
