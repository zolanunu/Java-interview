/**
 * 
 */
package com.java.leetcode.coding;

import java.util.ArrayList;

/**
 * @author zolanunu
 *
 */
public class UndirectedGraphNode {
	int label = 0;
	UndirectedGraphNode leftGraphNode = null;
	UndirectedGraphNode rightGraphNode = null;
	ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
	/**   
	 * @Title:  UndirectedGraphNode   
	 * @Description:    TODO(������һ�仰�����������������)   
	 * @param:    
	 * @throws   
	 */
	public UndirectedGraphNode(int label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}
}
