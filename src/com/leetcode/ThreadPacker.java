package com.leetcode;
public class ThreadPacker extends Thread {
	ProductShoes lrQueue;
	public ThreadPacker(ProductShoes lrQueue) {
		// TODO Auto-generated constructor stub
		this.lrQueue = lrQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			while(!lrQueue.lQueue.isEmpty() && !lrQueue.rQueue.isEmpty()) {
				ProductShoes.Shoe lShoe = lrQueue.lQueue.remove(0);
				ProductShoes.Shoe rShoe = lrQueue.rQueue.remove(0);
				System.out.println("打包线程，打包左鞋子和右鞋子，左鞋子库存"
						+ lrQueue.lQueue.size() + "右鞋子库存"
						+ lrQueue.rQueue.size());
				pack(lShoe, rShoe);
			}
			
		}
	}
	public void pack(ProductShoes.Shoe lShoe, ProductShoes.Shoe rShoe) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
