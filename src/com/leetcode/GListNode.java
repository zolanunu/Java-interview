package com.leetcode;



public class GListNode {
	GListNode mPh; // �����ı�ڵ�
	GListNode mPt; // �����ı�β�ڵ�
	int mtag; // ����� mtag = 0: ԭ�ӽڵ㣬 mtag = 1�� ��ڵ�
	Object mdata;
	
	public GListNode() {
		// TODO Auto-generated constructor stub
	}

	public GListNode(GListNode mPh, GListNode mPt, int mtag, Object mdata) {
		this.mPh = mPh;
		this.mPt = mPt;
		this.mtag = mtag;
		this.mdata = mdata;
	}
	
}
