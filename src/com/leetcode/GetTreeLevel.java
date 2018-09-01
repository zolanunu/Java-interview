/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class GetTreeLevel {
	public ListNode getTreeNode(TreeNode root, int deep) {
		ListNode ln = new ListNode(-1);
		ListNode p = ln;
		if(root == null || deep <= 0) {
			return null;
		}
		if(deep == 1) {
			p.next = new ListNode(root.val);
			p = p.next;
		} else {
			getTreeNode(root.left, deep - 1);
			getTreeNode(root.right, deep - 1);
		}
		return ln.next;
	}
}
