/**
 * 
 */
package com.java.leetcode.coding;



/**
 * @author zolanunu
 *
 */
public class FindKthToTail {
	public ListNode findKthListNode(ListNode head, int k) {
		if(head == null || k == 0) {
			return null;
		}
		ListNode aheadListNode =head;
		ListNode beheadNode = null;
		for(int i = 0; i < k; i++) {
			if(aheadListNode.next != null) {
				aheadListNode = aheadListNode.next;
			} else {
				return null;
			}
		}
		beheadNode = head;
		while(aheadListNode.next != null) {
			aheadListNode = aheadListNode.next;
			beheadNode = beheadNode.next;
		}
		return beheadNode;
	}
}
