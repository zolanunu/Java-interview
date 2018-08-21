/**
 * 
 */
package com.java.leetcode.coding;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class MyLoopQueue<T> implements Serializable {
	/***
	 * ѭ������ʵ��
	 * */
	private static final long serialVersionUID = -3689023675435L;
	
	private int DEFAULT_SIZE = 10;
	private int capacity; // ��������ĳ���
	
	private Object[] elementData; // ����һ������������ѭ�����е�Ԫ��
	
	private int front = 0; // ��ͷָ��
	private int rear = 0; // ��βָ��
	
	public MyLoopQueue() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	// ��һ����ʼ��Ԫ��������ѭ������
	public MyLoopQueue(T ele) {
		this();
		elementData[0] = ele;
		rear++;
	}
	/**
	 * ��һ��ָ���ĳ���������ѭ������
	 * */
	public MyLoopQueue(T eleT, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = eleT;
		rear++;
	}
	// ��ȡ�����С
	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return rear > front ? rear - front : capacity - (front - rear);
		}
	}
	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front && elementData[rear] == null;
	}
	
	public void add(T ele) {
		if(rear == front && elementData[front] != null) {
			throw new IndexOutOfBoundsException("��������");
		}
		elementData[rear] = ele;
		rear = rear + 1;
		// ���rear�Ѿ���ͷ�˵Ļ����Ǿ�תͷ
		rear = rear == capacity ? 0 :rear;
	}
	
	public T remove() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("���п���");
		}
		//�ȱ�������front�˵�Ԫ�ص�ֵ
		@SuppressWarnings("unchecked")
		T oldValue = (T) elementData[front];
		// �ͷ�front�˵�����
		elementData[front++] = null;
		front = front == capacity ? 0 : front;
		return oldValue;
	}
	
	@SuppressWarnings("unchecked")
	public T element() {
		// ���ض�ͷԪ��
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("���п���");
		}
		return (T)elementData[front];
	}
	
	public void clear() {
		// ��ն���
		Arrays.fill(elementData, null);
		front = rear = 0;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "[]";
		} else {
			if(front < rear) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for(int i = front; i < rear; i++) {
					sb.append(elementData[i].toString()+",");
				}
				int len = sb.length();
				return sb.delete(len-2, len).append("]").toString();
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for(int i = front; i < capacity; i++) {
					sb.append(elementData[i].toString()+",");
				}
				for(int i = 0; i < rear; i++) {
					sb.append(elementData[i] + ",");
				}
				int len = sb.length();
				return sb.delete(len-2, len).append("]").toString();
			}
		}
	}
	
	public static void main(String[] args) {
		MyLoopQueue<Integer> queue = new MyLoopQueue<Integer>(1, 5);
		System.out.println(queue.rear);
		queue.add(2);
		System.out.println(queue.rear);
		queue.add(3);
		System.out.println(queue.rear);
		queue.add(5);
		System.out.println(queue.rear);
		System.out.println(queue);
		
		queue.add(4);
		System.out.println(queue.rear);
		// System.out.println(queue);
		queue.remove();
		System.out.println("ɾ��һ��Ԫ���Ժ�����е�Ԫ���У�" + queue);
		
		
	}
}
