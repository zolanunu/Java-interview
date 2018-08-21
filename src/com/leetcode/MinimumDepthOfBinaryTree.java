/**
 * 
 */
package com.java.leetcode.coding;

import java.util.LinkedList;
import java.util.Queue;



/**
 * @author zolanunu
 *
 */
public class MinimumDepthOfBinaryTree {
	/**
	 * 二叉树的最低高度
	 * 广度优先搜索
	 * */
	
	public int minimumDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int minidepth = Integer.MAX_VALUE;
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		root.isvisit = true;
		int temDepth = 0;
		while(!que.isEmpty()) {
			
		}
		return 0;
	}
}
