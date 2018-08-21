package com.java.leetcode.coding;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class SimpleList<T extends Comparable<T>> {
	private class Node{
		private T data;
		private Node next;
		public Node() {
			
		}
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node head; //指向链表头节点的引用变量  
	private Node tail; //指向链表尾节点的引用变量  
	int size;
	
	public SimpleList() {
		head = null;
		tail = null;
	}
	public SimpleList(T data) {
		head = new Node(data, null);
		tail = head;
		size++;
	}
	
	public int length() {
		return size;
	}
	// 根据位置索引查找元素
	public T getElement(int index) {
		return findNodeByIndex(index).data;
	}
	
	public Node findNodeByIndex(int index) {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		Node curNode = head;
		for(int i = 0; i < size && curNode.next != null; curNode = curNode.next) {
			if(i == index) {
				return curNode;
			}
		}
		return null;
	}
	
	public int findIndexByElement(T element) {
		Node curNode = head;
		for(int i = 0; i < size && curNode.next!=null; curNode=curNode.next) {
			if(curNode.data.equals(element)) {
				return i;
			}
		}
		return -1;
	}
	// 插入, 在指定位置
	public void insert(int index, T ele) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		if(head == null) {
			add(ele);
		} else {
			if(index == 0) {
				addAtHead(ele);
			} else {
				Node preNode = findNodeByIndex(index-1);
				preNode.next = new Node(ele, preNode.next);
				size++;
			}
		}
	}
	// 插入 尾插法在每次在链表尾添加新节点 
	public void add(T ele) {
		if(head == null) {
			head = new Node(ele, null);
		} else {
			Node newNode = new Node(ele, null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	// 插入 头插法在链表头部加入新节点
	public void addAtHead(T ele) {
		head = new Node(ele, head);
		if(tail == null) {
			tail = head;
		}
	}
	
	public T delete(int index) {
		Node deleteNode = null;
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		if(index == 0) {
			deleteNode = head;
			head = head.next;
		} else {
			Node preNode = findNodeByIndex(index-1);
			deleteNode = preNode.next;
			preNode.next = deleteNode.next;
			deleteNode.next = null;
		}
		return deleteNode.data;
	}
	
	public T removeLast() {
		return delete(size-1);
	}
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder();
			for(Node curNode = head; curNode!=null; curNode=curNode.next) {
				sb.append(curNode.data.toString()+",");
			}
			int len =sb.length();
			return sb.delete(len-1, len).append("]").toString();
		}
	}
}

