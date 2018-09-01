package com.leetcode;

public class RemoveNthNodeFromEnd {
	/**
	 * 删除从尾开始的第N个节点
	 * */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = head; 
		for(int i = 0; i < n; i++) {
			// 先让cur指针从头走n步
			cur = cur.next;
		}
		// 此时走完以后，判断cur所指向的节点是否是尾节点之后了
		if(cur == null) {
			// 发现已经走完了，说明链表可能长度就刚好是n
			return head.next; // 那么就删除头结点了
		}
		while(cur.next != null) {
			// cur指针没有到尾的话，这个时候pre指针也开始从头开始遍历
			// 跟着cur指针遍历到尾为止
			// pre指向要移除元素的前一个元素
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}
