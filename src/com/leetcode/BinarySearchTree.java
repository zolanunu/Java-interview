package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.omg.CORBA.INTERNAL;


public class BinarySearchTree<T extends Comparable<T>> {
	private TNode<T> tHead;
	
	public static class TNode<T> {
		private TNode<T> parent; // parent
		private TNode<T> left; // leftchildren
		private TNode<T> right; // rightchildren
		private T value;
		
		public TNode<T> getP() {
			return parent;
		}
		
		public TNode<T> getLeft() {
			return left;
		}
		public TNode<T> getRight() {
			return right;
		}
		public T getValue() {
			return value;
		}
		public TNode() {
			
		}
		public TNode(T value, TNode<T> left, TNode<T> right, TNode<T> parent) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
	public BinarySearchTree() {
		
	}
	// �������� ǰ���ͺ�̽ڵ�  ������֪���й��������
	
	/**
	 * �������
	 * */
	
	public List<T> inOrder() {
		List<T> list = new ArrayList<T>();
		inOrderHelp(this.tHead, list);
		return list;
	}
	
	private void inOrderHelp(TNode<T> tNode, List<T> list) {
		if(tNode != null) {
			inOrderHelp(tNode.left, list);
			list.add(tNode.value);
			inOrderHelp(tNode.right, list);
		}
	}
	
	/**
	 * ��������ǵݹ�
	 * */
	
	public List<T> inOrderByStack() {
		List<T> list = new ArrayList<T>();
		inOrderHelpByStack(this.tHead, list);
		
		return list;
	}
	
	private void inOrderHelpByStack(TNode<T> tNode, List<T> list) {
		Stack<TNode<T>> stack = new Stack<TNode<T>>();
		TNode<T> pNode = tNode;
		while(pNode!=null || !stack.isEmpty()) {
			while(pNode!=null) {
				stack.push(pNode);
				pNode = pNode.left;
				
			}
			if(!stack.isEmpty()) {
				pNode = stack.peek();
				list.add(pNode.value);
				stack.pop();
				pNode = pNode.right;
			}
		}
	}
	/**
	 * ǰ������ǵݹ�
	 * */
	public List<T> preOrderByStack() {
		List<T> list = new ArrayList<T>();
		preOrderHelpByStack(this.tHead, list);
		return list;
	}
	
	private void preOrderHelpByStack(TNode<T> tNode, List<T> list) {
		Stack<TNode<T>> stack = new Stack<TNode<T>>();
		TNode<T> pNode = tNode;
		while(pNode!=null || !stack.isEmpty()) {
			while(pNode!=null) {
				list.add(pNode.value);
				stack.push(pNode);
				pNode = pNode.left;
			}
			if(!stack.isEmpty()) {
				pNode = stack.peek();
				stack.pop();
				pNode = pNode.right;
			}
		}
	}
	
	/**
	 * ������� �ǵݹ�
	 * */
	
	public List<T> postOrderByStack() {
		List<T> list = new ArrayList<T>();
		postOrderHelpByStack(this.tHead, list);
		return list;
	}
	
	private void postOrderHelpByStack(TNode<T> tNode, List<T> list) {
		Stack<TNode<T>> stack = new Stack<TNode<T>>();
		Stack<Integer> stack2 = new Stack<>();
		int i = 1;
		
		TNode<T> pNode = tNode;
		
		while(pNode!=null || !stack.isEmpty()) {
			while(pNode!=null) {
				
				stack.push(pNode);
				stack2.push(0);
				pNode = pNode.left;
			}
			while(!stack.isEmpty() && stack2.peek() == Integer.valueOf(i)) {
				stack2.pop();
				list.add(stack.pop().value);
			}

			if(!stack.isEmpty()) {
				stack2.pop();
				stack2.push(1);
				pNode = stack.peek();
				pNode = pNode.right;
			}
		}
	}
	
	/**
	 * ���ظ��ڵ�
	 * */
	public TNode<T> gettHead() {
		return tHead;
	}
	/**
	 * ��������е�ǰ���ڵ�
	 * */
	public TNode<T> precuror(TNode<T> tNode) {
		if(tNode != null) {
			if(tNode.left != null) {
				return getMax(tNode.left);
			}
			TNode<T> pNode = tNode.parent;
			TNode<T> cNode = tNode;
			// ����ڵ�x��������Ϊ�գ���ôǰ���ڵ�Ϊx��ĳһ�����Ƚڵ�ĸ��ڵ㣬���Ҹ����Ƚڵ�����Ϊ�丸�ڵ���Ҷ��� 
			while(pNode != null && pNode.left == cNode) {
				cNode = pNode;
				pNode = pNode.parent;
			}
			if(pNode!=null) {
				return pNode;
			}
			return null;
		}
		return null;
	}
	
	/**
	 * ��������еĺ�̽ڵ�
	 * */
	public TNode<T> successor(TNode<T> tNode) {
		if(tNode != null) {
			if(tNode.right!= null) {
				return getMax(tNode.right);
			}
			TNode<T> pNode = tNode.parent;
			TNode<T> cNode = tNode;
			
			while(pNode != null && pNode.right == cNode) {
				cNode = pNode;
				pNode = pNode.parent;
			}
			if(pNode!=null) {
				return pNode;
			}
			return null;
		}
		return null;
	}
	// �����С
	public TNode<T> getMax(TNode<T> tNode) {
		if(tNode==null) {
			return null;
		}
		TNode<T> cNode = tNode;
		TNode<T> pNode = null;
		while(cNode != null) {
			pNode = cNode;
			cNode = cNode.right;
		}
		return pNode;
	}
	
	public TNode<T> getMin(TNode<T> tNode) {
		TNode<T> cNode = tNode;
		TNode<T> pNode = null;
		while(cNode!=null) {
			pNode=cNode;
			cNode = cNode.left;
		}
		return pNode;
	}
	// �������
	
	public BinarySearchTree<T> insert(T value) {
		if(tHead == null) {
			tHead = new TNode<T>();
			tHead.parent = null;
			tHead.left = null;
			tHead.right = null;
			tHead.value = value;
			return this;
		}
		TNode<T> cNode = tHead;
		TNode<T> pNode = null;
		while(cNode != null) {
			pNode = cNode;
			if(value.compareTo(pNode.value) > 0) {
				cNode = cNode.right;
			} else if(value.compareTo(pNode.value) < 0) {
				cNode = cNode.left;
			} else {
				// �����Ѿ�������ڵ���
				System.out.println("the value existed...");
			}
		}
		// û�в��ҵ��ýڵ�Ļ�
		// �ҵ�Ҫ����Ľڵ�λ��
		TNode<T> tNode = new TNode<T>();
		tNode.value = value;
		tNode.left = null;
		tNode.right = null;
		tNode.parent = pNode;
		if(value.compareTo(pNode.value) > 0) {
			pNode.right = tNode;
		} else {
			pNode.left = tNode;
		}
		return this;
	}
	
	public TNode<T> searchValue(T value) {
		if(tHead == null) {
			return null;
		}
		TNode<T> cNode = tHead;
		while(cNode!=null) {
			if(value.compareTo(cNode.value) > 0) {
				cNode = cNode.right;
			} else if(value.compareTo(cNode.value) < 0) {
				cNode = cNode.left;
			} else {
				return cNode;
			}
		}
		return null; // û�в��ҵ�
	}
	// ɾ���ڵ�
	
	public TNode<T> delete(TNode<T> tNode) {
		if(tNode != null) {
			if(tNode.left == null && tNode.right == null) {
				if(tNode.parent == null) {
					this.tHead = null;
				} else if(tNode.parent.left == tNode) {
					tNode.parent.left = null;
				} else {
					tNode.parent.right = null;
				}
			} else if(tNode.left == null) {
				transplant(tNode, tNode.right);
			} else if(tNode.right == null) {
				transplant(tNode, tNode.left);
			} else { // ���Һ��Ӷ��ڣ��ҵ�tNode�ڵ�ĺ�̽ڵ�
				TNode<T> ttNode = getMin(tNode.right);
				if(ttNode.parent != tNode) {
					transplant(ttNode, ttNode.right);
					ttNode.right = ttNode.right;
					ttNode.right.parent = ttNode;
				}
				transplant(tNode, ttNode);
				ttNode.left = tNode.left;
				ttNode.left.parent = ttNode;
			}
		}
		return tNode;
	}
	private void transplant(TNode<T> f, TNode<T> t) {
		if(f.parent == null) {
			this.tHead = t;
		} else if(f== f.parent.left) {
			f.parent.left = t;
		} else {
			f.parent.right = t;
		}
		t.parent = f.parent;
	}
	
	public void testTraversal() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(2);
        bst.insert(16);
        bst.insert(1);
        bst.insert(4);
        bst.insert(11);
        List<Integer> list = bst.inOrder();
        for (Integer i : list)
            System.out.print(i + " ");
    }
	public static void main(String[] args) {
		 BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.insert(5);
	        bst.insert(2);
	        bst.insert(16);
	        bst.insert(1);
	        bst.insert(4);
	        bst.insert(11);
	        List<Integer> list = bst.inOrder();
	        for (Integer i : list)
	            System.out.print(i + " ");
	}
}
