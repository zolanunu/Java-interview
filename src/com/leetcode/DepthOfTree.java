/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class DepthOfTree {
	// ��һ���������
	
	// �ݹ�ʵ��
	
	public int depthOfTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftd = depthOfTree(root.left);
		int rightd = depthOfTree(root.right);
		
		return leftd >= rightd ? leftd + 1 : rightd + 1;
	}
	
	// ��һ��������С���
	
	public int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int l = minDepth(root.left);
		int r = minDepth(root.right);
		if(l==0||r==0) {
			return 1 + r + l;
		}
		return (l < r ? l : r) + 1;
	}
}
