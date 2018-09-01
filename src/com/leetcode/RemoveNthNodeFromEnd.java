package com.leetcode;

public class RemoveNthNodeFromEnd {
	/**
	 * ɾ����β��ʼ�ĵ�N���ڵ�
	 * */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = head; 
		for(int i = 0; i < n; i++) {
			// ����curָ���ͷ��n��
			cur = cur.next;
		}
		// ��ʱ�����Ժ��ж�cur��ָ��Ľڵ��Ƿ���β�ڵ�֮����
		if(cur == null) {
			// �����Ѿ������ˣ�˵��������ܳ��Ⱦ͸պ���n
			return head.next; // ��ô��ɾ��ͷ�����
		}
		while(cur.next != null) {
			// curָ��û�е�β�Ļ������ʱ��preָ��Ҳ��ʼ��ͷ��ʼ����
			// ����curָ�������βΪֹ
			// preָ��Ҫ�Ƴ�Ԫ�ص�ǰһ��Ԫ��
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}
