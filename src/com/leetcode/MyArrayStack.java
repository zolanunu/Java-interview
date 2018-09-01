package com.leetcode;

public class MyArrayStack<T> implements MyStack<T> {
	private Object[] objs = new Object[16];
	private int size= 0;
	/**
	 * ջ��˳��ջ����������ʵ�ֵ�
	 * */
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		// ���ջԪ��
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
	 * ��������
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
	public T pop() { // ���ݳ�ջ
		if(size==0) {
			return null;
		}
		return (T)objs[--size];
	}
	@SuppressWarnings("unchecked")
	public T peek() { // ȡջ��Ԫ��
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
