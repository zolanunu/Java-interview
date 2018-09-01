package com.leetcode;

import java.util.Vector;

public class Launch {
	public static void main(String[] args) throws InterruptedException {
		final Vector<ProductShoes.Shoe> lQueueShoes = new Vector<ProductShoes.Shoe>();
		final Vector<ProductShoes.Shoe> rQueueShoes = new Vector<ProductShoes.Shoe>();
		boolean lFalg = true;
		boolean rFlag = false;
		
		ProductShoes queue = new ProductShoes(lQueueShoes,rQueueShoes,lFalg,rFlag);
		for(int i = 0; i < 7; i++) {
			ThreadWorker worker = new ThreadWorker(queue);
			worker.start();
		}
				
		Thread.sleep(5000);
		
		ThreadMaster master = new ThreadMaster(queue);
		master.start();
		ThreadPacker packer = new ThreadPacker(queue);
		packer.start();
	}
}
