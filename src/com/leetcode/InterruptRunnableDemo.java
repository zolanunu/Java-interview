package com.leetcode;

public class InterruptRunnableDemo extends Thread {
	int i = 0;
	/**
	 * 在running的状态下调用interrupt方法
	 * */
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			i = i + 1;
			System.out.println("i = " + i + " this thread is running..." + Thread.currentThread().isInterrupted());
		}
		System.out.println("done.....");
	}
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new InterruptRunnableDemo();
		thread.start();
		Thread.sleep(100); // 并不是thread进行休息了
		System.out.println(thread.isInterrupted());
		thread.interrupt();
		System.out.println(thread.isInterrupted());
		System.out.println("what will happen");
	}
}
