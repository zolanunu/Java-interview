package com.leetcode;
public class ThreadWorker extends Thread {
	ProductShoes lrQueue;
	public ThreadWorker(ProductShoes lrQueue) {
		// TODO Auto-generated constructor stub
		this.lrQueue = lrQueue;
	}
	
	@Override
	
	public void run() {
		while(true) {
			if(lrQueue.lFlag) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				synchronized (lrQueue.lQueue) {
					lrQueue.lQueue.add(new ProductShoes.Shoe(ProductShoes.Shoe.LEFT));
					System.out.println(Thread.currentThread().getName()
							+ "工作线程，生产左鞋子，左鞋子库存" + lrQueue.lQueue.size()
							+ "右鞋子库存" + lrQueue.rQueue.size()
							);
					
				}
			} else {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				synchronized (lrQueue.rQueue) {
					lrQueue.rQueue.add(new ProductShoes.Shoe(ProductShoes.Shoe.RIGHT));
					System.out.println(Thread.currentThread().getName()
							+ "工作线程，生产右鞋子，左鞋子库存" + lrQueue.lQueue.size()
							+ "右鞋子库存" + lrQueue.rQueue.size()
							);
				}
			}
		}
	}
}
