package com.leetcode;

import java.awt.List;

public class HasLoopInList {
	/**
	 * 使用两个指针p1, p2。p1从表头开始一步一步往前走，遇到null则说明没有环，
	 * 返回false；p1每走一步，p2从头开始走，
	 * 如果遇到p2==p1.next，则说明有环true，如果遇到p2==p1，
	 * 则说明暂时没有环，继续循环。但是这个时间复杂度O(n^2)，
	 * */
	
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null) {
			return false;
		}
		ListNode p1 = head;
		while(p1!=null) {
			if(p1.next==p1) {
				return true;
			}
			ListNode p2 = head;
			while(p2!=p1) {
				if(p1==p1.next) {
					return true;
				}
				p2=p2.next;
			}
			p1=p1.next;
		}
		return false;
	}
	
	/**
	 * 快慢指针的方法，慢指针每次移动一次，快的指针每次移动两次
	 * 如果后面的两个指针相交，则说明是loop的
	 * */
	
	public boolean hasCycle1(ListNode head) {
		if(head==null||head.next==null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(slow!=null&&fast!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}
}
