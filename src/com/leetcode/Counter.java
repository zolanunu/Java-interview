package com.java.java_base;

public class Counter {
	public volatile static int count = 0;
	public static void inc() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		count = count + 1;
	}
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Counter.inc();
				}
			}).start();;
		}
		System.out.println("count = " + Counter.count);
	}
}
