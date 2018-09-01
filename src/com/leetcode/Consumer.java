/**
 * 
 */
package com.leetcode;

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
                System.out.println("consumer ฯ๛ทัมห:"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
