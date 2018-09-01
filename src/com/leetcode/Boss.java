package com.leetcode;

public class Boss implements ReceiveReport {
	private Worker worker;
	public Boss(Worker worker) {
		this.worker = worker;
	}
	/**
	 * 下达任务
	 * */
	
	public void sendTask() {
		worker.work(this);
	}
	@Override
	public void receiveReport(String name, String report) {
		System.out.println("收到："+name+" 的报告："+report);
	}
	
}
