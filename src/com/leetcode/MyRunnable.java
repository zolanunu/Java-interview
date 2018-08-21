package com.java.java_base;

public class MyRunnable implements Runnable {
	private int total;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			System.out.println("Thread name is: " + Thread.currentThread().getName());
			for(int i = 0; i < 10; i++) {
				total += i;
			}
			notify();
			System.out.println("notify后同步代码块中依然可以继续执行直到完毕");
		}
		System.out.println("执行notif后且同步代码块外的代码执行时机取决于线程调度");
	}
	public int getTotal() {
		return total;
	}
}
