package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Bosses implements ReceiveReports {
	private List<Workers> workers = new ArrayList<Workers>();
	private volatile int index; // ˳��
	
	public void addWorker(Workers worker) {
		workers.add(worker);
		worker.setReceiveReport(this);
	}
	
	/**
	 * �´�����
	 * */
	
	public void sendTask(final String task) {
		for (final Workers w:workers) {
			new Thread(new Runnable() { @Override public void run() { w.work(task); } }).start(); }
		
	}
	@Override
	public void receiveReport(Workers work, String report) {
		// TODO Auto-generated method stub
		int index = ++this.index;
		System.out.println(work.getName()+"��õ�"+index+"��");
		if (index <= 3){ //��ǰ����������
			work.getReward(1000.0*(4-index));
		}
	}
	
	
}
