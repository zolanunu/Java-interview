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
	 * 循环队列实现
	 * */
	private static final long serialVersionUID = -3689023675435L;
	
	private int DEFAULT_SIZE = 10;
	private int capacity; // 保存数组的长度
	
	private Object[] elementData; // 定义一个数组来保存循环队列的元素
	
	private int front = 0; // 队头指针
	private int rear = 0; // 队尾指针
	
	public MyLoopQueue() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	// 以一个初始化元素来创建循环队列
	public MyLoopQueue(T ele) {
		this();
		elementData[0] = ele;
		rear++;
	}
	/**
	 * 以一个指定的长度来创建循环队列
	 * */
	public MyLoopQueue(T eleT, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = eleT;
		rear++;
	}
	// 获取数组大小
	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return rear > front ? rear - front : capacity - (front - rear);
		}
	}
	// 判断是否为空
	public boolean isEmpty() {
		return rear == front && elementData[rear] == null;
	}
	
	public void add(T ele) {
		if(rear == front && elementData[front] != null) {
			throw new IndexOutOfBoundsException("队列满了");
		}
		elementData[rear] = ele;
		rear = rear + 1;
		// 如果rear已经到头了的话，那就转头
		rear = rear == capacity ? 0 :rear;
	}
	
	public T remove() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("队列空了");
		}
		//先保留队列front端的元素的值
		@SuppressWarnings("unchecked")
		T oldValue = (T) elementData[front];
		// 释放front端的数据
		elementData[front++] = null;
		front = front == capacity ? 0 : front;
		return oldValue;
	}
	
	@SuppressWarnings("unchecked")
	public T element() {
		// 返回队头元素
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("队列空了");
		}
		return (T)elementData[front];
	}
	
	public void clear() {
		// 清空队列
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
		System.out.println("删除一个元素以后队列中的元素有：" + queue);
		
		
	}
}
