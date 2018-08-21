/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class BalanceBinaryTree {
	// �ж��Ƿ���ƽ�������
	public boolean isBalance(TreeNode root) {
		if(root == null) {
			return true;
		}
		if(Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		} else {
			return isBalance(root.left) && isBalance(root.right);
		}
	}
	
	public int height(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			return Math.max(height(root.left), height(root.right)) + 1;
		}
	}
}
