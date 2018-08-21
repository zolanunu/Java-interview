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
			System.out.println("notify��ͬ�����������Ȼ���Լ���ִ��ֱ�����");
		}
		System.out.println("ִ��notif����ͬ���������Ĵ���ִ��ʱ��ȡ�����̵߳���");
	}
	public int getTotal() {
		return total;
	}
}
