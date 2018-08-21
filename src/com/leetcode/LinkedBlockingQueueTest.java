/**
 * 
 */
package com.java.java_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zolanunu
 *
 */
public class LinkedBlockingQueueTest {
	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		threadPool.execute(new Producer(queue));
		threadPool.execute(new Consumer(queue));
		if(!threadPool.isShutdown()) {
			threadPool.shutdown();
			try {
				threadPool.awaitTermination(300, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
