package com.leetcode;

import java.util.Vector;

public class ProductShoes {
	// 假设100工人，其中98个生产鞋子，一个打包工人，另一个是主观
	
	// 左鞋子的制作周期比右鞋子慢，打包的时候必须左右各取一只
	
	// ProductShoes 为双队列，左队列负责左鞋子，右队列负责生产右鞋子
	
	Vector<Shoe> lQueue;
	Vector<Shoe> rQueue;
	
	volatile boolean lFlag;
	volatile boolean rFlag;
	public ProductShoes(Vector<Shoe> lQueue, Vector<Shoe> rQueue,
			boolean lFlag, boolean rFlag) {
		//super();
		this.lQueue = lQueue;
		this.rQueue = rQueue;
		this.lFlag = lFlag;
		this.rFlag = rFlag;
	}
	public static class Shoe {
		final static int LEFT = 0;
		final static int RIGHT = 1;
		int type;
		
		public Shoe(int type) {
			this.type = type;
		}
	}
	
	
}
