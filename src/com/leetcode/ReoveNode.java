/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class ReoveNode {
	public boolean removeNode(ListNode pNode) {
		if(pNode == null || pNode.next == null) {
			return false;
		}
		ListNode qNode = pNode.next;
		pNode.val = qNode.val;
		pNode.next = qNode.next;
		return true;
	}
}
