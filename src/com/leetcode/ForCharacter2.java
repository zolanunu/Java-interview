/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 * 
 */
public class ForCharacter2 {
	/*
	 * Description��һ�����̵߳����⣬������̣߳�˳���ӡ����1~���������ÿ5������Ϊ1�� Author��ZhangRuirui
	 * Date��2018/05/25 Email��zhangrrbugfree@163.com
	 */
	private static volatile int orderNum = 1;// ��Ҫ��ʱ������Ϊvolatile���͵�

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				synchronized (this) {
					try {
						int threadId = Integer.parseInt(Thread.currentThread()
								.getName());
						while (true) {
							if (orderNum % 5 == threadId || orderNum % 5 == 0) {
								if (orderNum % 5 == 0)
									System.out.println("threadid = " + 5 + " "
											+ orderNum++);
								else
									System.out.println("threadid = " + threadId
											+ " " + orderNum++);
								Thread.sleep(1000);// Ϊ��ִ��Ч�����ĸ����
								notifyAll();
							} else {
								wait();
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(r, "1");
		Thread t2 = new Thread(r, "2");
		Thread t3 = new Thread(r, "3");
		Thread t4 = new Thread(r, "4");
		Thread t5 = new Thread(r, "5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
