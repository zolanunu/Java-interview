/**
 * 
 */
package com.datastructure;

import com.java.leetcode.coding.TreeNode;

/**
 * @author zolanunu
 *
 */
public class BuildTree {
	/**
	 * 已知前序序列和中序序列建树
	 * **/
	public TreeNode buildTree(int[] preOrder, int[] inOrder) {
		TreeNode root = constructTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
		return root;
	}
	public TreeNode constructTree(int[] pre, int sp, int ep, int[] in, int sin, int ein) {
		if(sp >  ep || sin > ein) {
			return null;
		}
		TreeNode root = new TreeNode(pre[sp]);
		for(int i = sin; i <= ein; i++) {
			if(in[i] == pre[sp]) {
				root.left = constructTree(pre, sp+1, sp+i-sin, in, sin, i-1);
				root.right = constructTree(pre, i-sin+sp, ep, in, i+1, ein);
			}
		}
		return root;
	}
	
	public TreeNode inPostConstructTree(int[] inOrder, int[] postOrder) {
		if(inOrder == null || postOrder == null) {
			return null;
		}
		return reContructTree(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1);
	}
	public TreeNode reContructTree(int[] in, int sin, int ein, int[] post, int sp, int ep) {
		if(sin > ein || sp > ep) {
			return null;
		}
		TreeNode root = new TreeNode(post[ep]);
		for(int i = sin; i <= ein; i++) {
			if(in[i] == post[ep]) {
				root.left = reContructTree(in, sin, i-1, post, sp, sp+i-sin-1);
				root.right = reContructTree(in, i+1, ein, post, sp+i-sin, ep-1);
			}
		}
		return root;
	}
}
