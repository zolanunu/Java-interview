package com.java.java_base;

public class ThreadMaster extends Thread {
	ProductShoes lrQueue;
	public ThreadMaster(ProductShoes lrQueue) {
		// TODO Auto-generated constructor stub
		this.lrQueue = lrQueue;
	}
	// ThreadMasterΪЭ�����̣߳����ȵ������Ҷ��еĿ�档
	@Override
	public void run() {
		while(true) {
			if(lrQueue.lQueue.size() < lrQueue.rQueue.size()) {
				lrQueue.lFlag = true;
				lrQueue.rFlag = false;
			} else {
				lrQueue.lFlag = false;
				lrQueue.rFlag = true;
			}
		}
	}
}
