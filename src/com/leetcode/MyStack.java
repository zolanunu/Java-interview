package com.java.leetcode.coding;

public interface MyStack<T> {
	boolean isEmpty();
	void clear();
	int length();
	boolean push(T data);
	T pop(); // 数据出栈
	T peek(); // 取栈顶元素
}
