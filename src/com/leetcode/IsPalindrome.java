/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */

/**
 * https://www.cnblogs.com/HorribleMe/p/4878833.html
 * */
public class IsPalindrome {
	public boolean isPalindrome(ListNode pHead) {
		int length = 0, i;
		ListNode p1 = null, p2 = pHead, p3 = pHead;
		if(pHead == null || pHead.next == null) {
			return true;
		}
		while(p3 != null) {
			p3 = p3.next;
			length++;
		}
		
		for(i = 0; i < (length / 2); i++) {
			p3= p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		if(length % 2 == 1) {
			p3 = p3.next;
		}
		while(p3 != null && p1 != null) {
			if(p3.val != p1.val) {
				return false;
			}
			p3 = p3.next;
			p1 = p1.next;
		}
		return true;
	}
}
