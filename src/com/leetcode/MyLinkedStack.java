package com.java.leetcode.coding;



public class MyLinkedStack<T> implements MyStack<T> {
	private Node top;
	private int size;
	
	private final class Node {
		
		private Node preNode;
		private T data;
	}
	
	public MyLinkedStack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		top = null;
		size = 0;
	}
	public int length() {
		return size;
	}
	public boolean push(T data) {
		Node node = new Node();
		node.data = data;
		node.preNode = top;
		top = node;
		size++;
		return true;
	}
	
	public T pop() {
		if(top!=null) {
			Node node = top;
			top = top.preNode;
			size--;
			return node.data;
		}
		return null;
	}
	
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return size == 0 ? null : top.data;
	}
	
	public static void main(String[] args) {
		// 测试顺序栈和链栈的出栈速度
		System.out.println("MyArrayStack..........");
		MyArrayStack<String> arrayStack = new MyArrayStack<>();
		int num = 10000000;
		long s = System.currentTimeMillis();
		for(int i = 0; i < num; i++) {
			String string = Integer.toString(i);
			arrayStack.push(string);
		}
		long e1 = System.currentTimeMillis();
		System.out.println("push time: " + (e1 - s));
		while(arrayStack.pop()!=null) {
			
		}
		long e2 = System.currentTimeMillis();
		System.out.println("push time: " + (e2 - e1));
		
		System.out.println("MyLinkedStack..........");
		MyLinkedStack<String> linkStack = new MyLinkedStack<>();
		int num1 = 10000000;
		long s1 = System.currentTimeMillis();
		for(int i = 0; i < num1; i++) {
			String string = Integer.toString(i);
			linkStack.push(string);
		}
		long e3 = System.currentTimeMillis();
		System.out.println("push time: " + (e3 - s1));
		while(linkStack.pop()!=null) {
			
		}
		long e4 = System.currentTimeMillis();
		System.out.println("push time: " + (e4 - e3));  
	}

	
}
