package com.leetcode;



public class GListNode {
	GListNode mPh; // 广义表的表节点
	GListNode mPt; // 广义表的表尾节点
	int mtag; // 广义表： mtag = 0: 原子节点， mtag = 1： 表节点
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
