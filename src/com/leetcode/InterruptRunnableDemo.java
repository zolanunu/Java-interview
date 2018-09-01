package com.leetcode;

public class InterruptRunnableDemo extends Thread {
	int i = 0;
	/**
	 * ��running��״̬�µ���interrupt����
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
		Thread.sleep(100); // ������thread������Ϣ��
		System.out.println(thread.isInterrupted());
		thread.interrupt();
		System.out.println(thread.isInterrupted());
		System.out.println("what will happen");
	}
}
