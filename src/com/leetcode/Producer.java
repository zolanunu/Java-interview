/**
 * 
 */
package com.java.java_base;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zolanunu
 *
 */
public class Producer extends Thread {
	private LinkedBlockingQueue<String> queue;
	public Producer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("Éú²ú³ö£º" + i);
			try {
				Thread.sleep(100);
				queue.add(new String("producer: " + i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
