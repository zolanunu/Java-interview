/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class ReverseList {
	/**
	 * ��ת������
	 * */
	// ��������
	public static ListNode reverseNode(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode preListNode = null;
		ListNode curListNode = head;
		ListNode nextNode = curListNode.next;
		while(curListNode != null){
			curListNode.next = preListNode;
			preListNode = curListNode;
			curListNode = nextNode.next;
			nextNode = nextNode.next;
		}
		
		return preListNode;
	}
}
