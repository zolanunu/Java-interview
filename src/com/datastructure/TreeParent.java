/**
 * 
 */
package com.datastructure;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

/**
 * @author zolanunu
 *
 */
public class TreeParent<E> {
	public static class Node<T> {
		T data; // 保存节点元素
		
		int parent; // 保存父亲节点位置
		
		public Node() {
			
		}
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, int parent){
			this.data = data;
			this.parent = parent;
		}
		
		public String toString() {
			return "TreeParent$Node [data = " + data + ", parent = " + parent + "]";
		}
	}
	
	private final int DEFAULT_TREE_SIZE = 100;
	
	private int  treeSize = 0;
	
	private  Node<E>[] nodes; // 使用一个Node[]数组来记录该树里的所有节点
	
	private int nodeNums; // 记录树的节点数目
	
	@SuppressWarnings("unchecked")
	public TreeParent(E data) { // 以该节点的创建树
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}
	
	
	@SuppressWarnings("unchecked")
	public TreeParent(E data, int treeSize){ // 为指定根节点，指定treeSize创建树
		this.treeSize = treeSize;
		
		nodes = new Node[treeSize];
		
		nodes[0] = new Node<E>(data, -1);
		
		nodeNums++;
	}
	
	// 为指定节点添加子节点
	
	public void addNode(E data, Node parent) {
		for(int i = 0; i < treeSize; i++) {
			// 找到数组中第一个为null的元素，该元素保存新的节点
			if(nodes[i] == null) {
				nodes[i] = new Node(data, pos(parent));
				nodeNums++;
				return ;
			}
		}
		throw new RuntimeException("该树已经满了，无法添加新节点");
	}
	
	public boolean empty() {
		return nodes[0] == null;
	}
	
	// 返回根节点
	public Node<E> root() {
		return nodes[0];
	}
	
	
	// 返回指定节点的父亲节点
	public Node<E> parent(Node node) {
		return nodes[node.parent];
	}
	
	// 返回指定节点的所有子节点
	
	public List<Node<E>> children(Node parent) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		for(int i = 0; i < treeSize; i++) {
			if(nodes[i] != null && nodes[i].parent == pos(parent)) {
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	// 返回树的深度
	public int deep(){
		// 用于记录节点的最大深度
		int max = 0;
		for(int i = 0; i < treeSize && nodes[i] != null; i++) {
			// 初始化本节点的深度
			int def = 1;
			int m = nodes[i].parent;
			while(m != -1 && nodes[m] != null) {
				m = nodes[m].parent;
				def++;
			}
			if(max < def) {
				max = def;
			}
		}
		return max;
	}
	
	public  int pos(Node node) {
		for(int i = 0; i < treeSize; i++) {
			if(nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
	
	
	

}
