/**
 * 
 */
package com.java.leetcode.coding;

import java.util.Stack;

/**
 * @author zolanunu
 *
 */
public class FindSuccessor {
	public int findSucc(TreeNode root, int p) {
		
		if(root == null) {
			return -1;
		}
		// œ»÷––Ú±È¿˙
		Stack<TreeNode> s = new Stack<>();
		int re = -1;
		boolean flag = false;
		TreeNode t = root;
		
		while(!s.isEmpty() || t != null) {
			if(t != null) {
				s.add(t);
				t = t.left;
			} else {
				TreeNode temp = s.peek();
				s.pop();
				if(flag) {
					re = temp.val;
					break;
				}
				if(temp.val == p) {
					flag = true;
				}
				t = temp.right;
			}
		}
		return re;
	}
	
	public TreeNode search(TreeNode root, int p) {
		if(root == null) {
			return null;
		}
		TreeNode cur = root;
		if(cur.val < p) {
			search(cur.right, p);
		} else if(cur.val > p) {
			search(cur.left, p);
		} else {
			return cur;
		}
		return null;
	}
}
