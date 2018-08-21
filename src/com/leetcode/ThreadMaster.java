package com.java.java_base;

public class ThreadMaster extends Thread {
	ProductShoes lrQueue;
	public ThreadMaster(ProductShoes lrQueue) {
		// TODO Auto-generated constructor stub
		this.lrQueue = lrQueue;
	}
	// ThreadMaster为协调者线程，均匀调整左右队列的库存。
	@Override
	public void run() {
		while(true) {
			if(lrQueue.lQueue.size() < lrQueue.rQueue.size()) {
				lrQueue.lFlag = true;
				lrQueue.rFlag = false;
			} else {
				lrQueue.lFlag = false;
				lrQueue.rFlag = true;
			}
		}
	}
}
