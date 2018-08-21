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
	 * ǰ�����������
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
	 * �������������
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
	 * �������������
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
	 * �ǵݹ�汾
	 * ǰ�����
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
	 * �ǵݹ��������
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
	 * �ǵݹ�������
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
				// ���Ӻ��Һ���ͬʱΪ�գ����ߵ�ǰ�������ӻ��Һ����Ѿ���������  
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
	 * ��α���
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
	 * ���ҽڵ�
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
	 * ������С�ڵ�
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
	 * ���ڵ�
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
	 * �ҽڵ�ĺ�̽ڵ㣬Ҳ���ǲ��ҵ����ڵ�ǰ�ڵ�ֵ����С�ڵ�
	 * */
	public BSTNode<T> successor(BSTNode<T> r) {
		if(r == null) {
			return r;
		}
		// ���x�����Һ��ӣ����̽ڵ��ǣ����Һ���Ϊ������������С�ڵ�
		if(r.right != null) {
			return searchMin(r.right);
		}
		
		/** û���Һ��ӣ���x�����¿��ܣ�
		 * x��һ�����ӣ���x�ĺ�̽ڵ������ĸ��׽ڵ�
		 * x��һ���Һ��ӣ������x����͵ĸ��׽ڵ�
		 * ���Ҹø����Ҫ��������"���ҵ������"��͵ĸ����"����"x��ǰ�����"��
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
	 * ɾ���ڵ�z�������ر�ɾ���Ľڵ�
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
	 * ���ٶ�����
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
