/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zolanunu
 * 
 */
public class PrintList {
	/**
	 * 剑指Offer：面试题6 从尾到头打印链表
	 * */

	public static void print(ListNode head) {
		/**
		 * 利用栈数据结构
		 * */

		Deque<ListNode> listNodes = new LinkedList<ListNode>();

		if (head == null) {
			System.out.println("链表是空的");
		}
		ListNode l = head;
		while (l != null) {
			listNodes.addFirst(l);
			l = l.next;
		}

		while (!listNodes.isEmpty()) {
			System.out.print(listNodes.removeFirst().val + " ");
		}

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (listNode == null) {
			return al;
		}
		ListNode p = listNode;
		while (p != null) {
			al.add(p.val);
			p = p.next;
		}
		int lower = 0;
		int higher = al.size() - 1;
		while (lower < higher) {
			int temp = al.get(lower);
			al.set(lower, al.get(higher));
			al.set(higher, temp);
			lower++;
			higher--;
		}
		return al;
	}

}
