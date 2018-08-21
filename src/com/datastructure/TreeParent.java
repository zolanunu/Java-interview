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
		T data; // ����ڵ�Ԫ��
		
		int parent; // ���游�׽ڵ�λ��
		
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
	
	private  Node<E>[] nodes; // ʹ��һ��Node[]��������¼����������нڵ�
	
	private int nodeNums; // ��¼���Ľڵ���Ŀ
	
	@SuppressWarnings("unchecked")
	public TreeParent(E data) { // �Ըýڵ�Ĵ�����
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}
	
	
	@SuppressWarnings("unchecked")
	public TreeParent(E data, int treeSize){ // Ϊָ�����ڵ㣬ָ��treeSize������
		this.treeSize = treeSize;
		
		nodes = new Node[treeSize];
		
		nodes[0] = new Node<E>(data, -1);
		
		nodeNums++;
	}
	
	// Ϊָ���ڵ�����ӽڵ�
	
	public void addNode(E data, Node parent) {
		for(int i = 0; i < treeSize; i++) {
			// �ҵ������е�һ��Ϊnull��Ԫ�أ���Ԫ�ر����µĽڵ�
			if(nodes[i] == null) {
				nodes[i] = new Node(data, pos(parent));
				nodeNums++;
				return ;
			}
		}
		throw new RuntimeException("�����Ѿ����ˣ��޷�����½ڵ�");
	}
	
	public boolean empty() {
		return nodes[0] == null;
	}
	
	// ���ظ��ڵ�
	public Node<E> root() {
		return nodes[0];
	}
	
	
	// ����ָ���ڵ�ĸ��׽ڵ�
	public Node<E> parent(Node node) {
		return nodes[node.parent];
	}
	
	// ����ָ���ڵ�������ӽڵ�
	
	public List<Node<E>> children(Node parent) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		for(int i = 0; i < treeSize; i++) {
			if(nodes[i] != null && nodes[i].parent == pos(parent)) {
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	// �����������
	public int deep(){
		// ���ڼ�¼�ڵ��������
		int max = 0;
		for(int i = 0; i < treeSize && nodes[i] != null; i++) {
			// ��ʼ�����ڵ�����
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
