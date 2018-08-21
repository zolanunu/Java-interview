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
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public UndirectedGraphNode(int label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}
}
