package com.java.java_base;

import java.util.concurrent.CountDownLatch;

public class DeadLock {
	private static Object o1 = new Object();
	private static Object o2 = new Object();
	
	private static CountDownLatch countDownLatch = new CountDownLatch(2);
	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			@Override
			public void run() {
				synchronized (o1) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("线程1获得锁1");
					synchronized (o2) {
						System.out.println("线程1 获得锁2");
						countDownLatch.countDown();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				synchronized (o1) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("线程2获得锁1");
					synchronized (o2) {
						System.out.println("线程2 获得锁2");
						countDownLatch.countDown();
					}
				}
			}
		}.start();
		countDownLatch.await();
		System.out.println("执行完毕");
	}
}
