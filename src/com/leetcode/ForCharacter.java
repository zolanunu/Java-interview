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
	 * 一个多线程的问题，用三个线程，顺序打印字母A-Z，输出结果是1A 2B 3C 1D 2E…打印完毕最后输出一个Ok。
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
						System.out.println("线程id:" + threadId + " " + (char)c++);
						i++;
						if(i == 26) {
							System.out.println("哈哈，希望自己努力找到工作！");
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
	 * 这样写的话，可能会造成资源浪费，所以我们可以通过加锁进行限制，但是加锁后，
	 * 因为sleep不会释放锁，会导致其他线程无法获得执行机会。因此需要配合wait和notifyAll。
	 * */
	public static void afterLockForCharacter() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (this) {
					try {
						int threadId = Integer.parseInt(Thread.currentThread().getName());
						System.out.println("当前线程id:" + threadId + " ");
						while(i < 26) {
							if(i % 3 == threadId - 1) {
								System.out.println("线程id：" + threadId + (char)c++);
								i++;
								if(i == 26) {
									System.out.println("哈哈，希望自己能找到工作");
								}
								notifyAll(); // 唤醒其他的进程
							} else {
								wait(); // 阻塞其他进程
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
