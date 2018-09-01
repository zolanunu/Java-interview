package com.leetcode;

public class Lock {
	private boolean isLocked = false;
	public synchronized void lock() throws InterruptedException {
		while(isLocked) { // while(isLocked)ѭ�������ֱ�������������
			wait();
		}
		isLocked = true;
	}
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}
