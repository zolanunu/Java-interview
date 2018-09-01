package com.leetcode;

import java.awt.List;

public class HasLoopInList {
	/**
	 * ʹ������ָ��p1, p2��p1�ӱ�ͷ��ʼһ��һ����ǰ�ߣ�����null��˵��û�л���
	 * ����false��p1ÿ��һ����p2��ͷ��ʼ�ߣ�
	 * �������p2==p1.next����˵���л�true���������p2==p1��
	 * ��˵����ʱû�л�������ѭ�����������ʱ�临�Ӷ�O(n^2)��
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
	 * ����ָ��ķ�������ָ��ÿ���ƶ�һ�Σ����ָ��ÿ���ƶ�����
	 * ������������ָ���ཻ����˵����loop��
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
