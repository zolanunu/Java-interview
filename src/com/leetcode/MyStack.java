package com.java.leetcode.coding;

public interface MyStack<T> {
	boolean isEmpty();
	void clear();
	int length();
	boolean push(T data);
	T pop(); // ���ݳ�ջ
	T peek(); // ȡջ��Ԫ��
}
