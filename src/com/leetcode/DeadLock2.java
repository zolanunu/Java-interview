package com.leetcode;

public class DeadLock2 implements Runnable {
	public int flag = 1;
	// ��̬������������ж����������
	public static Object o1 = new Object(), o2 = new Object();

	@Override
	public void run() {
		System.out.println("flag = " + flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (o2) {
				System.out.println("1");
			}
		}
		if(flag == 2) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			synchronized (o1) {
				System.out.println("2");
			}
		}
	}
	
	public static void main(String[] args) {
		DeadLock2 t1 = new DeadLock2();
		DeadLock2 t2 = new DeadLock2();
		t1.flag = 1;
		t2.flag = 2;
		// td1,td2�����ڿ�ִ��״̬����JVM�̵߳�����ִ���ĸ��߳��ǲ�ȷ���ġ�  
        // td2��run()������td1��run()֮ǰ����  
		new Thread(t1).start();
		new Thread(t2).start();
	}
}
