package com.leetcode;
public class ThreadTest {
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		synchronized (r) {
			try {
				System.out.println("maint hread �ȴ�t�߳�ִ����");
				r.wait();
				System.out.println("��notity���ѣ����Լ���ִ��");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("main thread ����ȴ���������������");
			}
			System.out.println("�߳�tִ����ӽ��" + r.getTotal());
		}
	}
}
