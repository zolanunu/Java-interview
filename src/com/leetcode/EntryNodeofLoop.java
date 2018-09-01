/**
 * 
 */
package com.leetcode;

import java.util.HashSet;

/**
 * @author zolanunu
 *
 */
public class EntryNodeofLoop {
	public ListNode entryNodeOfLoop(ListNode pHead) {
		HashSet<ListNode> hs = new HashSet<>();
		ListNode p = pHead; 
		while(p != null) {
			if(!hs.add(p)) {
				return p;
			}
			p = p.next;
		}
		return null;
	}
	
}
