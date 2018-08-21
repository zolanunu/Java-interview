package com.java.leetcode.coding;

import java.util.Stack;

public class MinStack {
	/**
	 * ����һ������ȡ��СԪ�صĺ�����ջ���ݽṹ
	 * */
	/**
	 * һ�ֽ���취�ǣ��������������ռ�
	 * */
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minIntegers = new Stack<>();
	public void push(int node) {
		stack.push(node);
		if(minIntegers.empty()) {//��СֵջΪ��
			minIntegers.add(node);
		} else {
			// ��Ϊ�յ����
			if(node < minIntegers.peek().intValue()) {
				minIntegers.push(node); // ��ǰ��Ҫѹ��ջ��Ԫ�ظ�С������
			} else {
				minIntegers.push(minIntegers.peek()); // �������,minStacks��Stack����������һ��
			}
		}
	}
	
	public void pop() {
		if(!stack.empty()) {// �ǿյĻ���ֱ�ӵ����Ԫ�ؾͺ�
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
