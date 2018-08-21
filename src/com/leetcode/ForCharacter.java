/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ForCharacter {
	/**
	 * һ�����̵߳����⣬�������̣߳�˳���ӡ��ĸA-Z����������1A 2B 3C 1D 2E����ӡ���������һ��Ok��
	 * */
	private static char c = 'A';
	private static int i = 0; 
	public static void main(String[] args) {
		Runnable runable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int threadId = Integer.parseInt(Thread.currentThread().getName());
				while(i < 26) {
					if(i % 3 == threadId - 1) {
						System.out.println("�߳�id:" + threadId + " " + (char)c++);
						i++;
						if(i == 26) {
							System.out.println("������ϣ���Լ�Ŭ���ҵ�������");
						}
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
		};
//		Thread t1 = new Thread(runable, "1");
//		Thread t2 = new Thread(runable, "2");
//		Thread t3 = new Thread(runable, "3");
//		t1.start();
//		t2.start();
//		t3.start();
		afterLockForCharacter();
	}
	
	/**
	 * ����д�Ļ������ܻ������Դ�˷ѣ��������ǿ���ͨ�������������ƣ����Ǽ�����
	 * ��Ϊsleep�����ͷ������ᵼ�������߳��޷����ִ�л��ᡣ�����Ҫ���wait��notifyAll��
	 * */
	public static void afterLockForCharacter() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (this) {
					try {
						int threadId = Integer.parseInt(Thread.currentThread().getName());
						System.out.println("��ǰ�߳�id:" + threadId + " ");
						while(i < 26) {
							if(i % 3 == threadId - 1) {
								System.out.println("�߳�id��" + threadId + (char)c++);
								i++;
								if(i == 26) {
									System.out.println("������ϣ���Լ����ҵ�����");
								}
								notifyAll(); // ���������Ľ���
							} else {
								wait(); // ������������
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}
		};
		Thread t1 = new Thread(runnable, "1");
		Thread t2 = new Thread(runnable, "2");
		Thread t3 = new Thread(runnable, "3");
		t1.start();
		t2.start();
		t3.start();
	}
}
