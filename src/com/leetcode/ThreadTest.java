package com.leetcode;
public class ThreadTest {
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		synchronized (r) {
			try {
				System.out.println("maint hread 等待t线程执行完");
				r.wait();
				System.out.println("被notity唤醒，得以继续执行");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("main thread 本想等待，但被意外打断了");
			}
			System.out.println("线程t执行相加结果" + r.getTotal());
		}
	}
}
