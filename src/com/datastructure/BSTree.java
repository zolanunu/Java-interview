/**
 * 
 */
package com.datastructure;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zolanunu
 *
 */
public class BSTree<T extends  Comparable<T>>{
	private BSTNode<T> mRoot;
	public class BSTNode<T extends Comparable<T>> {
		T key;
		BSTNode<T> left;
		BSTNode<T> right;
		BSTNode<T> parent;
		public BSTNode (T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
			this.key =  key;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		public T getKey() {
			return key;
		}
		public String toString() {
			return "key:" + key;
		}
	}
	
	public BSTree() {
		mRoot = null;
	}
	/**
	 * 前序遍历二叉树
	 * */
	private void preOrder(BSTNode<T> tree) {
		if(tree != null) {
			System.out.println(tree.key + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	
	public void preOrder() {
		preOrder(mRoot);
	}
	/**
	 * 中序遍历二叉树
	 * */
	private void inOrder(BSTNode<T> tree) {
		if(tree != null) {
			
			preOrder(tree.left);
			System.out.println(tree.key + " ");
			preOrder(tree.right);
		}
	}
	
	public void inOrder() {
		inOrder(mRoot);
	}
	
	/**
	 * 后序遍历二叉树
	 * */
	
	private void postOrder(BSTNode<T> tree) {
		if(tree != null) {
			
			preOrder(tree.left);
			
			preOrder(tree.right);
			System.out.println(tree.key + " ");
		}
	}
	
	public void postOrder() {
		postOrder(mRoot);
	}
	
	
	/**
	 * 非递归版本
	 * 前序遍历
	 * */
	
	private void preOrderByStack(BSTNode<T> root) {
		Stack<BSTNode<T>> nodelist = new Stack<BSTNode<T>>();
		BSTNode<T> pRoot = root;
		if(root == null) {
			return ;
		}
		while(pRoot != null || !nodelist.isEmpty()) {
			while(pRoot != null) {
				System.out.println(pRoot.key + " ");
				nodelist.add(pRoot);
				pRoot = pRoot.left;
			}
			if(!nodelist.isEmpty()) {
				pRoot = nodelist.peek();
				nodelist.pop();
				pRoot = pRoot.right;
			}
		}
	}
	
	
	public void preOrderByStack() {
		preOrderByStack(mRoot);
	}
	
	/**
	 * 非递归中序遍历
	 * */
	
	private void inOrderByStack(BSTNode<T> root) {
		Stack<BSTNode<T>> nodelist = new Stack<BSTNode<T>>();
		BSTNode<T> pRoot = root;
		if(root == null) {
			return;
		}
		while(pRoot != null || !nodelist.isEmpty()) {
			while(pRoot != null) {
				nodelist.push(pRoot);
				pRoot = pRoot.left;
			}
			if(!nodelist.isEmpty()) {
				pRoot = nodelist.peek();
				System.out.println(pRoot.key+" ");
				nodelist.pop();
				pRoot = pRoot.right;
			}
		}
	}
	
	public void inOrderByStack() {
		inOrderByStack(mRoot);
	}
	
	/**
	 * 非递归后序遍历
	 * */
	
	private void postOrderByStack(BSTNode<T> root) {
		Stack<BSTNode<T>> nodelist = new Stack<BSTNode<T>>();
		
		BSTNode<T> cur;
		BSTNode<T> pre = null;
		if(root == null) {
			return ;
		}
		nodelist.push(root);
		while(!nodelist.isEmpty()) {
			cur = nodelist.peek();
			if((cur.left == null && cur.right == null) || (pre!=null&&(pre == cur.left||pre == cur.right))) {
				// 左孩子和右孩子同时为空，或者当前结点的左孩子或右孩子已经遍历过了  
				System.out.println(cur.key + " ");
				nodelist.pop();
				pre = cur;
			} else {
				if(cur.right != null) {
					nodelist.push(cur.right);
				}
				if(cur.left != null) {
					nodelist.push(cur.left);
				}
			}
		}
	}
	public void postOrderByStack() {
		postOrderByStack(mRoot);
	}
	
	/**
	 * 层次遍历
	 * */
	
	private void levelTraverse(BSTNode<T> root) {
		if(root == null) {
			return ;
		}
		LinkedList<BSTNode<T>> sLinkedList = new LinkedList<>();
		sLinkedList.add(root);
		while(!sLinkedList.isEmpty()) {
			BSTNode<T> pNode = sLinkedList.getFirst();
			sLinkedList.removeFirst();
			System.out.println(pNode.key + " ");
			if(pNode.left != null) {
				sLinkedList.add(pNode.left);
			}
			if(pNode.right != null) {
				sLinkedList.add(pNode.right);
			}
		}

	}
	
	public void levelTraverse() {
		levelTraverse(mRoot);
	}
	
	/**
	 * 查找节点
	 * */
	
	private BSTNode<T> search(BSTNode<T> r, T key) {
		if(r == null) {
			return null;
		}
		BSTNode<T> cur = r;
		int cmp = key.compareTo(cur.key);
		if(cmp < 0) {
			return search(cur.left, key);
		} else if(cmp > 0) {
			return search(cur.right, key);
		} else {
			return cur;
		}
	}
	
	public BSTNode<T> search(T key) {
		return search(mRoot, key);
	}
	
	private BSTNode<T> searchByStack(BSTNode<T> r, T key) {
		if(r == null) {
			return r;
		}
		BSTNode<T> cur = r;
		while(cur != null) {
			int cmp = key.compareTo(cur.key);
			if(cmp < 0) {
				cur = cur.left;
			} else if(cmp > 0) {
				cur = cur.right;
			} else {
				return cur;
			}
		}
		return cur;
	}

	
	public BSTNode<T> searchByStack(T key) {
		return searchByStack(mRoot, key);
	}
	
	/**
	 * 查找最小节点
	 * */
	
	private BSTNode<T> searchMin(BSTNode<T> r) {
		if(r == null) {
			return r;
		}
		BSTNode<T> cur = r;
		while(cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}
	
	public T searchMin() {
		BSTNode<T> p = searchMin(mRoot);
		if(p != null) {
			return p.key;
		}
		return null;
	}
	
	/**
	 * 最大节点
	 * */
	
	private BSTNode<T> searchMax(BSTNode<T> r) {
		if(r == null) {
			return null;
		}
		BSTNode<T> cur = r;
		while(cur.right != null) {
			cur = cur.right;
		}
		return cur;
	}
	
	public T searchMax() {
		BSTNode<T> p = searchMax(mRoot);
		if(p != null) {
			return p.key;
		}
		return null;
	}
	
	/**
	 * 找节点的后继节点，也就是查找到大于当前节点值的最小节点
	 * */
	public BSTNode<T> successor(BSTNode<T> r) {
		if(r == null) {
			return r;
		}
		// 如果x存在右孩子，则后继节点是：以右孩子为根的子树的最小节点
		if(r.right != null) {
			return searchMin(r.right);
		}
		
		/** 没有右孩子，则x有以下可能：
		 * x是一个左孩子，则x的后继节点是他的父亲节点
		 * x是一个右孩子，则查找x的最低的父亲节点
		 * 并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
		 * 
		 * */
		
		BSTNode<T> y = r.parent;
		while(y != null && r == y.left) {
			r = y;
			y = y.parent;
		}
		return y;
	}
	
	public BSTNode<T> predecessor(BSTNode<T> x) {
		if(x.left != null) {
			return searchMax(x.left);
		}
		BSTNode<T> y = x.parent;
		while(y != null && x == y.left) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	private void insert(BSTree<T> bst, BSTNode<T> z) {
		int cmp;
		BSTNode<T> y = null;
		BSTNode<T> x = bst.mRoot;
		
		while(x != null) {
			y = x;
			cmp = z.key.compareTo(x.key);
			if(cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		
		z.parent = y;
		if(y == null) {
			bst.mRoot = z;
		} else {
			cmp = z.key.compareTo(y.key);
			if(cmp < 0) {
				y.left = z;
			} else {
				y.right = z;
			}
		}
	}
	
	public void insert(T key) {
		BSTNode<T> zNode = new BSTNode<T>(key, null, null, null);
		if(zNode != null) {
			insert(this, zNode);
		}
	}
	
	/**
	 * 删除节点z，并返回被删除的节点
	 * */
	
	
	private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
		BSTNode<T> x = null;
		BSTNode<T> y = null;
		if(z.left == null || z.right == null) {
			y = z;
		} else {
			y = successor(z);
		}
		if(y.left != null) {
			x = y.left;
		} else {
			x = y.right;
		}
		if(x != null) {
			x.parent = y.parent;
		}
		if(y.parent == null) {
			bst.mRoot = x;
		} else if(y == y.parent.left) {
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		
		if(y != z) {
			z.key = y.key;
		}
		
		return y;
	}
	
	public void remove(T key) {
		BSTNode<T> z, n;
		if((z = search(mRoot, key)) != null) {
			if((n = remove(this, z)) != null) {
				n = null;
			}
		}
	}
	
	/**
	 * 销毁二叉树
	 * */
	
	private void destroy(BSTNode<T> tree) {
		if(tree == null) {
			return ;
		}
		
		if(tree.left != null) {
			destroy(tree.left);
		}
		if(tree.right != null) {
			destroy(tree.right);
		}
		
		tree = null;
	}
	
	public void clear() {
		destroy(mRoot);
		mRoot = null;
	}
	
	
}
