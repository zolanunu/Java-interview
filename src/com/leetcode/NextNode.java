/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class NextNode {
	/**
	 * ���������������������
	 * �����������һ���ڵ�
	 * */
	public TreeNode nextNode(TreeNode node) {
		if(node == null) {
			return null;
		}
		if(node.right != null) {
			node = node.right;
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}
		while(node.parent != null) {
			if(node.parent.left == node) {
				return node.parent;
			}
			node = node.parent;
		}
		return null;
	}
}
