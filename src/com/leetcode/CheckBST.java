/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class CheckBST {
	public boolean checkBST(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return true;
		}
		boolean isLeftBST = true, isRightBST = true;
		if(root.left != null && (root.val >= root.left.val)) {
			isLeftBST = checkBST(root.left);
		} else if(root.left != null && (root.val < root.left.val)){
			isLeftBST = false;
		} else {
			
		}
		if(root.right != null && root.val <= root.right.val) {
			isRightBST = checkBST(root.right);
		} else if(root.right != null && (root.val >  root.right.val)) {
			isRightBST = false;
		} else {
			
		}
		return isLeftBST && isRightBST;
	}
}
