/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class BuildMinimalBST {
	public int buildMinimalBST(int[] vals) {
		int length = vals.length;
		if(length <= 0) {
			return 0;
		} else {
			TreeNode root = buildBST(vals, 0, length - 1);
			return highBST(root);
		}
	}
	public TreeNode buildBST(int[] vals,  int left, int right) {
		if(left > right) {
			return null;
		}
		int middle = left + (right -  left) / 2;
		TreeNode root = new TreeNode(vals[middle]);
		root.left = buildBST(vals, left, middle - 1);
		root.right = buildBST(vals, middle + 1, right);
		
		return root;
	}
	
	public int highBST(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = highBST(root.left);
		int right = highBST(root.right);
		if(left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}
	
	public int buildMinimal1(int[] vals) {
		int size = vals.length;
		return (int)(Math.log(size +1  ) / Math.log(2)) + 1;
	}
}
