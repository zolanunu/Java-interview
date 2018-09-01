package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Bosses implements ReceiveReports {
	private List<Workers> workers = new ArrayList<Workers>();
	private volatile int index; // 顺序
	
	public void addWorker(Workers worker) {
		workers.add(worker);
		worker.setReceiveReport(this);
	}
	
	/**
	 * 下达任务
	 * */
	
	public void sendTask(final String task) {
		for (final Workers w:workers) {
			new Thread(new Runnable() { @Override public void run() { w.work(task); } }).start(); }
		
	}
	@Override
	public void receiveReport(Workers work, String report) {
		// TODO Auto-generated method stub
		int index = ++this.index;
		System.out.println(work.getName()+"获得第"+index+"名");
		if (index <= 3){ //给前三名发奖金
			work.getReward(1000.0*(4-index));
		}
	}
	
	
}
