package com.leetcode;

import java.util.Vector;

public class ProductShoes {
	// ����100���ˣ�����98������Ь�ӣ�һ��������ˣ���һ��������
	
	// ��Ь�ӵ��������ڱ���Ь�����������ʱ��������Ҹ�ȡһֻ
	
	// ProductShoes Ϊ˫���У�����и�����Ь�ӣ��Ҷ��и���������Ь��
	
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
