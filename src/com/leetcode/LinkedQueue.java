/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */

import java.io.Serializable;

public class LinkedQueue<T> implements Serializable {

	private static final long serialVersionUID = -6726728595616312615L;

	// ����һ���ڲ���Node��Nodeʵ�����������еĽڵ㡣
	private class Node {

		private T data;// ����ڵ������

		private Node next;// ָ���¸��ڵ������

		// �޲����Ĺ�����
		public Node() {
		}

		// ��ʼ��ȫ�����ԵĹ�����
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node front;// ����������е�ͷ�ڵ�

	private Node rear;// ����������е�β�ڵ�

	private int size;// ��������������Ѱ����Ľڵ���

	/**
	 * <p>
	 * Title: LinkQueue
	 * </p>
	 * <p>
	 * Description: ������������
	 * </p>
	 */
	public LinkedQueue() {
		// �������У�front��rear����null
		front = null;
		rear = null;
	}

	/**
	 * <p>
	 * Title: LinkQueue
	 * </p>
	 * <p>
	 * Description: ��ָ������Ԫ�������������У���������ֻ��һ��Ԫ��
	 * </p>
	 */
	public LinkedQueue(T element) {
		front = new Node(element, null);
		// ֻ��һ���ڵ㣬front��rear��ָ��ýڵ�
		rear = front;
		size++;
	}

	/**
	 * @Title: size
	 * @Description: ��ȡ˳����еĴ�С
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * @Title: offer
	 * @Description: ���
	 * @param element
	 */
	public void offer(T element) {
		// ����������л��ǿ�������
		if (front == null) {
			front = new Node(element, null);
			rear = front;// ֻ��һ���ڵ㣬front��rear��ָ��ýڵ�
		} else {
			Node newNode = new Node(element, null);// �����½ڵ�
			rear.next = newNode;// ��β�ڵ��nextָ�������Ľڵ�
			rear = newNode;// ���½ڵ���Ϊ�µ�β�ڵ�
		}
		size++;
	}

	/**
	 * @Title: poll
	 * @Description: ����
	 * @return
	 */
	public T poll() {
		Node oldFront = front;
		front = front.next;
		oldFront.next = null;
		size--;
		return oldFront.data;
	}

	/**
	 * @Title: peek
	 * @Description: ���ض��ж�Ԫ�أ�����ɾ�����ж�Ԫ��
	 * @return
	 */
	public T peek() {
		return rear.data;
	}

	/**
	 * @Title: isEmpty
	 * @Description: �ж�˳������Ƿ�Ϊ�ն���
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @Title: clear
	 * @Description: ���˳�����
	 */
	public void clear() {
		// ��front��rear�����ڵ㸳Ϊnull
		front = null;
		rear = null;
		size = 0;
	}

	public String toString() {
		// ������Ϊ��������ʱ
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = front; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}

	public static void main(String[] args) {
		LinkedQueue<String> queue = new LinkedQueue<String>("aaaa");
		// �������Ԫ��
		queue.offer("bbbb");
		queue.offer("cccc");
		System.out.println(queue);
		// ɾ��һ��Ԫ�غ�
		queue.poll();
		System.out.println("ɾ��һ��Ԫ�غ�Ķ��У�" + queue);
		// �ٴ����һ��Ԫ��
		queue.offer("dddd");
		System.out.println("�ٴ����Ԫ�غ�Ķ��У�" + queue);
		// ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��
		queue.poll();
		// �ٴμ���һ��Ԫ��
		queue.offer("eeee");
		System.out.println(queue);
	}
}
