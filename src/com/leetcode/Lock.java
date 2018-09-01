package com.leetcode;

public class Lock {
	private boolean isLocked = false;
	public synchronized void lock() throws InterruptedException {
		while(isLocked) { // while(isLocked)循环，它又被叫做“自旋锁
			wait();
		}
		isLocked = true;
	}
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}
