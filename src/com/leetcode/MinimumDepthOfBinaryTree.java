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
	 * ����������͸߶�
	 * �����������
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
