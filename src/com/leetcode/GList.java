package com.leetcode;

import java.awt.List;
import java.util.Stack;

import javax.print.attribute.standard.Severity;

public class GList {
	/***
	 * 广义表：表中的节点可是是原子也可以是广义表
	 * 
	 * */

	public static int ATOM = 0;
	public static int LIST = 1;

	private char mStartSymb = '(';
	private char mEndSymb = ')';

	private GListNode listNode;

	public GList() {
		listNode = new GListNode(null, null, LIST, null);
	}

	public GList(GList gl) {
		if (gl != null) {
			listNode = gl.listNode;
		}
	}

	public GList(String mString) {
		if (mString == null) {
			throw new NullPointerException();
		}
		initGlist(mString);
	}

	// 递归方式建立广义表

	private void initGlist(String genTable) {
		String ts = genTable.replaceAll("\\s", "");
		int len = ts.length();
		Stack<Character> symbStack = new Stack<Character>();
		Stack<GListNode> nodeStck = new Stack<GListNode>();
		initSymbolicCharactor(ts);
		listNode = new GListNode(null, null, LIST, null);
		GListNode itemNode, tableNode = listNode, tmpNode;
		for (int i = 0; i < len; i++) {
			if (ts.charAt(i) == mStartSymb) {
				tmpNode = new GListNode(null, null, LIST, null);
				// tableNode = tableNode.mPt;
				symbStack.push(ts.charAt(i));
				if (symbStack.size() > 1) {
					nodeStck.push(tableNode);
					tableNode.mPh = tmpNode;
					tableNode = tableNode.mPh;
				} else {
					tableNode.mPt = tmpNode;
					tableNode = tableNode.mPt;
				}
			} else if (ts.charAt(i) == mEndSymb) {
				if (symbStack.isEmpty()) {
					throw new IllegalArgumentException(
							"IllegalArgumentException in constructor GList!...");
				}
				if (symbStack.size() > 1) {
					tableNode = nodeStck.pop();
				}
				symbStack.pop();
			} else if (ts.charAt(i) == ',') {
				tableNode.mPt = new GListNode(null, null, LIST, null);
				tableNode = tableNode.mPt;
			} else {
				itemNode = new GListNode(null, null, ATOM, ts.charAt(i));
				tableNode.mPh = itemNode;
			}
		}

		if (!symbStack.isEmpty()) {
			throw new IllegalArgumentException(
					"IllegalArgumentException in constructor GList!...");
		}
	}

	private void initSymbolicCharactor(String ts) {
		mStartSymb = ts.charAt(0);
		switch (mStartSymb) {
		case '(':
			mEndSymb = ')';
			break;
		case '{':
			mEndSymb = '}';
			break;
		case '[':
			mEndSymb = ']';
			break;
		default:
			throw new IllegalArgumentException(
					"IllegalArgumentException ---> initSymbolicCharactor");
		}
	}

	public void print() {
		print(listNode);
	}

	private void print(GListNode GListNode) {
		if (GListNode == null) {
			return;
		}
		if (GListNode.mTag == 0) {
			System.out.print(GListNode.mData.toString() + " \t");
		}
		print(GListNode.mPh);
		print(GListNode.mPt);

	}

	public int depth() { // 广义表的深度
		if (listNode == null) {
			throw new NullPointerException(
					"Generalized Table is null !.. ---> method depth");
		}
		return depth(listNode);
	}

	private int depth(GListNode GListNode) {
		if (GListNode == null || GListNode.mTag == ATOM) {
			return 0;
		}
		int depHeader = 0, depTear = 0;
		depHeader = 1 + depth(GListNode.mPh);
		depTear = depth(GListNode.mPt);
		return depHeader > depTear ? depHeader : depTear;
	}

	public int length() { // 广义表的长度
		if (listNode == null || listNode.mPt == null) {
			return -1;
		}
		int tLen = 0;
		GListNode GListNode = listNode;
		while (GListNode.mPt != null) {
			GListNode = GListNode.mPt;
			if (GListNode.mPh == null && GListNode.mPt == null) {
				break;
			}
			tLen++;
		}
		return tLen;
	}

	public GList getHeader() {
		if (isEmpty())
			return null;
		GListNode GListNode = listNode.mPt;
		GList gt = new GList();
		gt.listNode.mPt = GListNode.mPh;
		return gt;
	}

	public GList getTear() {
		if (isEmpty())
			return null;
		GListNode GListNode = listNode.mPt;
		GList gt = new GList();
		gt.listNode.mPt = GListNode.mPt;
		return gt;
	}

	public boolean isEmpty() {
		if (listNode == null) {
			return true;
		}
		GListNode GListNode = listNode.mPt;
		return GListNode == null || GListNode.mPh == null;
	}

	public class GListNode {// 广义表节点
		GListNode mPh; // 广义表的表节点
		GListNode mPt; // 广义表表尾节点
		int mTag; // mTag == 0 , 院子节点 ; mTag == 1 , 表节点 。
		Object mData; // 广义表的数据值

		public GListNode(GListNode ph, GListNode pt, int tag, Object data) {
			mPh = ph;
			mPt = pt;
			mTag = tag;
			mData = data;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String tStr = "((),(a,b,c),a,d,((d,g,(c))),(k,g),c)";
		String p = "((),a,b,(a,b,c),(a,(a,b),c))";
		String p2 = "((()),2)";
		// String space = "()";
		String big = "{{a,b},{{a,g},{h},{a,n,f,{a,b,c}}},c}";
		String middle = "[[p],[[d,f,[g]]],[h],[2]]";
		GList gTab = new GList(middle);
		// GList header, tear;
		// // gTab.print();
		// // System.out.println();
		System.out.println("length: " + gTab.length());
		System.out.println("depth: " + gTab.depth());
		//
		// header = gTab.getHeader();
		// if (header != null) {
		// System.out.println("header: ");
		// header.print();
		// }
		// tear = gTab.getTear();
		//
		// if (tear != null) {
		// System.out.println("tear: ");
		// tear.print();
		// }
		// gTab.print();
		// System.out.println();
		// GList gTab4 = null;
		// GList gTab2 = new GList(gTab4);
		// gTab2.print();
		// gTab2 = new GList(gTab);
		// gTab2.print();
	}
}
