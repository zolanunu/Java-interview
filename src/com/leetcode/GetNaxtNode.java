package com.leetcode;


public class GetNaxtNode {
	public TreeLinkNode getNext(TreeLinkNode node) {
		if(node==null) return null;
        if(node.right!=null){    //�����������������������������ڵ�
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //û�����������ҵ�һ����ǰ�ڵ��Ǹ��ڵ����ӵĽڵ�
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //�˵��˸��ڵ���û�ҵ����򷵻�null
	}
}
