/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Stack;

/**
 * @author zolanunu
 * https://www.cnblogs.com/MrListening/p/5697459.html
 */
public class TwoStacksToQueue {
	/**
	 * 剑指offer
	 * 面试题9：两个栈实现队列
	 * */
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	public void push(int node) {
		stack1.add(node);
	}
	
	
	public int pop() {
		if(stack1.isEmpty() && stack2.isEmpty()) {
		}
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int top = stack2.pop();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return top;
	}
}
