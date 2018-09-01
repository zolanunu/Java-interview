/**
 * 
 */
package com.leetcode;

import java.awt.List;

/**
 * @author zolanunu
 * 
 */
public class DeleteDuplicateNode {
	public ListNode deleteDuplicateNode(ListNode pHead) {
		if (pHead == null || pHead.next == null) { // ֻ��0����1����㣬�򷵻�
			return pHead;
		}
		if (pHead.val == pHead.next.val) { // ��ǰ������ظ����
			ListNode pNode = pHead.next;
			while (pNode != null && pNode.val == pHead.val) {
			// ����ֵ�뵱ǰ�����ͬ��ȫ�����,�ҵ���һ���뵱ǰ��㲻ͬ�Ľ��
				pNode = pNode.next;
			}
			return deleteDuplicateNode(pNode); // �ӵ�һ���뵱ǰ��㲻ͬ�Ľ�㿪ʼ�ݹ�
		} else { // ��ǰ��㲻���ظ����
			pHead.next = deleteDuplicateNode(pHead.next); // ������ǰ��㣬����һ����㿪ʼ�ݹ�
			return pHead;
		}
	}
}
