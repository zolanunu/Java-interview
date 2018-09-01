package com.leetcode;
import java.io.IOException;

public class TestThread {
	private int i = 10;
	private Object object = new Object();
	
	public static void main(String[] args) throws IOException {
		TestThread tt = new TestThread();
		MyThread t1 = tt.new MyThread();
		MyThread t2 = tt.new MyThread();
		t1.start();
		t2.start();
 	}
	
	class MyThread extends Thread {
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			synchronized (object) {
				i++;
				System.out.println("i:" + i);
				try {
					System.out.println("thread: " + Thread.currentThread().getName() + "in sleeping time......");
					Thread.currentThread().sleep(100000);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				System.out.println("Thread: " + Thread.currentThread().getName() + " sleep end......");
				i++;
				System.out.println("i:" + i);
			}
		}
	}
}
