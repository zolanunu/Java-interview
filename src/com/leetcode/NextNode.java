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
	 * 二叉树中中序遍历二叉树
	 * 求二叉树的下一个节点
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
