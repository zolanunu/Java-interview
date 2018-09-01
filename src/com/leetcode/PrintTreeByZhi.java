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
public class PrintTreeByZhi {
	public List<List<Integer>> zigPrint(TreeNode root) {
		if(root==null) {
			return null;
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); // ��ջ����
		
		int depth = 0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> temp = new LinkedList<>();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.offer(node.left);
				}
				if(node.right!=null) {
					queue.offer(node.right);
				}
				if(depth%2==0) {
					temp.add(node.val); // ��ջ����
				} else {
					temp.addFirst(node.val); // ��ͷ������Ԫ��
				}
			}
			depth++;
			list.add(temp);
		}
		return list;
	}
}
