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
	 * ��ָOffer��������6 ��β��ͷ��ӡ����
	 * */

	public static void print(ListNode head) {
		/**
		 * ����ջ���ݽṹ
		 * */

		Deque<ListNode> listNodes = new LinkedList<ListNode>();

		if (head == null) {
			System.out.println("�����ǿյ�");
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
