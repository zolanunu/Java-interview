package com.leetcode;

public class MyArrayStack<T> implements MyStack<T> {
	private Object[] objs = new Object[16];
	private int size= 0;
	/**
	 * 栈，顺序栈，是用数组实现的
	 * */
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		// 清空栈元素
		for(int i = 0; i < size; i++) {
			objs[size] = null;
		}
		size = 0;
	}
	public int length() {
		return size;
	}
	
	public boolean push(T data) {
		// insert element in the top
		if(size >= objs.length) {
			resize();
		}
		objs[size++] = data;
		return true;
	}
	
	/**
	 * 数组扩容
	 * */
	public void resize() {
		Object[] temp = new Object[objs.length*3/2+1];
		for(int i = 0; i < size; i++) {
			temp[i] = objs[i];
			objs[i] = null;
		}
		objs = temp;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() { // 数据出栈
		if(size==0) {
			return null;
		}
		return (T)objs[--size];
	}
	@SuppressWarnings("unchecked")
	public T peek() { // 取栈顶元素
		return size == 0 ? null :(T)objs[size-1];
	}
	
	public String toString() {
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("MyArrayStack:[");
		for(int i = 0; i < size; i++) {
			sbBuilder.append(objs[i].toString());
			if(i != size - 1) {
				sbBuilder.append(", ");
			}
		}
		sbBuilder.append("]");
		return sbBuilder.toString();
	}
}
