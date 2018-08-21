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
	
	private Node head; //ָ������ͷ�ڵ�����ñ���  
	private Node tail; //ָ������β�ڵ�����ñ���  
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
	// ����λ����������Ԫ��
	public T getElement(int index) {
		return findNodeByIndex(index).data;
	}
	
	public Node findNodeByIndex(int index) {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
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
	// ����, ��ָ��λ��
	public void insert(int index, T ele) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
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
	// ���� β�巨��ÿ��������β����½ڵ� 
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
	// ���� ͷ�巨������ͷ�������½ڵ�
	public void addAtHead(T ele) {
		head = new Node(ele, head);
		if(tail == null) {
			tail = head;
		}
	}
	
	public T delete(int index) {
		Node deleteNode = null;
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
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

