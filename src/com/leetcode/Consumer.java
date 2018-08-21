/**
 * 
 */
package com.java.java_base;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zolanunu
 *
 */
public class Consumer extends Thread {
	private LinkedBlockingQueue<?> queue;

    public Consumer(LinkedBlockingQueue<String> q) {
        this.queue =q;
    }
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("consumer ������:"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
