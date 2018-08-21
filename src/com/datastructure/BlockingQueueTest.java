package com.datastructure;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {
	/**
	 * ����װƻ��������
	 */
	public static class Basket {
		// ���ӣ��ܹ�����3��ƻ��
		BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

		// ����ƻ������������
		public void produce() throws InterruptedException {
			// put��������һ��ƻ������basket���ˣ��ȵ�basket��λ��
			basket.put("An apple");
		}

		// ����ƻ������������ȡ��
		public String consume() throws InterruptedException {
			// get����ȡ��һ��ƻ������basketΪ�գ��ȵ�basket��ƻ��Ϊֹ
			String apple = basket.take();
			return apple;
		}

		public int getAppleNumber() {
			return basket.size();
		}

	}

	// �����Է���
	public static void testBasket() {
		// ����һ��װƻ��������
		final Basket basket = new Basket();
		// ����ƻ��������
		class Producer implements Runnable {
			public void run() {
				try {
					while (true) {
						// ����ƻ��
						System.out.println("������׼������ƻ����"
								+ System.currentTimeMillis());
						basket.produce();
						System.out.println("����������ƻ����ϣ�"
								+ System.currentTimeMillis());
						System.out.println("���������ƻ����" + basket.getAppleNumber()
								+ "��");
						// ����300ms
						Thread.sleep(300);
					}
				} catch (InterruptedException ex) {
				}
			}
		}
		// ����ƻ��������
		class Consumer implements Runnable {
			public void run() {
				try {
					while (true) {
						// ����ƻ��
						System.out.println("������׼������ƻ����"
								+ System.currentTimeMillis());
						basket.consume();
						System.out.println("����������ƻ����ϣ�"
								+ System.currentTimeMillis());
						System.out.println("���������ƻ����" + basket.getAppleNumber()
								+ "��");
						// ����1000ms
						Thread.sleep(1000);
					}
				} catch (InterruptedException ex) {
				}
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		// ��������10s����������ֹͣ
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		service.shutdownNow();
	}

	public static void main(String[] args) {
		BlockingQueueTest.testBasket();
	}
}