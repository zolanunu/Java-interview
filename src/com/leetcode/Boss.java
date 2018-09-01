package com.leetcode;

public class Boss implements ReceiveReport {
	private Worker worker;
	public Boss(Worker worker) {
		this.worker = worker;
	}
	/**
	 * �´�����
	 * */
	
	public void sendTask() {
		worker.work(this);
	}
	@Override
	public void receiveReport(String name, String report) {
		System.out.println("�յ���"+name+" �ı��棺"+report);
	}
	
}
