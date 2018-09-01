/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zolanunu
 *
 */
public class LevelTraverseTree {
	// 二叉树层序遍历，进一步提问：要求每层打印出一个换行符
	public ArrayList<Integer> levelVisit(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root==null) {
			return null;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			list.add(cur.val);
			if(cur.left!=null) {
				queue.add(cur.left);
			}
			if(cur.right!=null) {
				queue.add(cur.right);
			}
		}
		return list;
	}
}
