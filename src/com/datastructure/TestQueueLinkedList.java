/**
 * 
 */
package com.datastructure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zolanunu
 *
 */
public class TestQueueLinkedList {
	public static<T> void test(Queue<T> queue, Generator<T> generator, int count) {
		for(int i = 0; i < count; i++) {
			queue.add(generator.next());
		}
		while(queue.peek()!=null) {
			// µ¯³ö¶ÓÁÐ
			System.out.print(queue.remove()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		test(new LinkedList<String>(), new MyGenerator(), 10);
		System.out.println("heloo....");
		test(new PriorityQueue<String>(), new MyGenerator(), 10);
	}
}
