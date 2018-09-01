package com.leetcode;

public class InterruptWaitingDemo extends Thread {
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				// 模拟任务代码
				Thread.sleep(2000); //
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(isInterrupted()); // false
				Thread.currentThread().interrupt(); // 重设中断位为true
			}
		}
		System.out.println(isInterrupted()); // true
	}
	public static void main(String[] args) {
		InterruptWaitingDemo thread = new InterruptWaitingDemo();
		thread.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		thread.interrupt();
	}
}
