/**
 * 
 */
package com.leetcode;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class SequenceQueue<T> implements Serializable {
	/**
	 * 
	 * 顺序队列
	 * */
	private static final long serialVersionUID = 7333344126529379197L;
	private int DEFAULT_SIZE = 10;
	private Object[] elementData;
	private int front;
	private int rear;
	private int capacity;
	
	public SequenceQueue() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity]; 
	}
	public SequenceQueue(T ele) {
		this();
		elementData[0] = ele;
		rear++;
	}
	public SequenceQueue(int initSize) {
		elementData = new Object[initSize];
	}
	public SequenceQueue(T ele, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = ele;
		rear++;
	}
	
	public int size() {
		return rear - front;
	}
	
	public void offer(T ele) {
		// 入队
		ensureCapacity(rear+1);
		elementData[rear++] = ele;
	}
	
	private void ensureCapacity(int minCapacity) {
		// 可能需要扩容
		int oldLength = elementData.length;
		if(minCapacity > oldLength) {
			int newCapacity = (oldLength*3)/2+1;
			if(newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	
	
	/**
	 * 出队
	 * */
	@SuppressWarnings("unchecked")
	public T poll() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("队列空了");
		}
		T oldValue = (T)elementData[front];
		elementData[front++] = null;
		return oldValue;
	}
	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("队列空了");
		}
		return (T)elementData[front];
	}
	public void clear() {
		Arrays.fill(elementData, null);
		front = 0;
		rear = 0;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "[]";
		} else {
			StringBuilder sbBuilder = new StringBuilder("[");
			for(int i = front; i < rear; i++) {
				sbBuilder.append(elementData[i].toString()+", ");
			}
			int len = sbBuilder.length();
			return sbBuilder.delete(len - 2, len).append("]").toString();
		}
	}
}
