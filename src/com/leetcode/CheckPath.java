/**
 * 
 */
package com.java.leetcode.coding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author zolanunu
 * 
 */
public class CheckPath {
	public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		return check(a, b) || check(b, a);
	}
	/*
	 * 这里的left，right好像不太有意义，主要根据邻接矩阵遍历
	 * 利用栈，首先a自身入栈以及其临街矩阵所有节点入栈，入栈前都进行判断
	 * 若该点邻居都不是b，则该点出栈，继续上述遍历
	 * 为了防止环的产生，已经入栈过的点不再入栈，用map管理
	 */
	public boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
		if(a == null || b == null) {
			return false;
		}
		if(a == b) {
			return true;
		}
		Map<UndirectedGraphNode, Boolean> checkMap = new HashMap<UndirectedGraphNode, Boolean>();
		LinkedList<UndirectedGraphNode> searchQueue = new LinkedList<>();
		searchQueue.add(a);
		checkMap.put(a, true);
		while(!searchQueue.isEmpty()) {
			UndirectedGraphNode currentNode = searchQueue.pop();
			if(currentNode.neighbors != null) {
				for(int i = 0; i < currentNode.neighbors.size(); i++) {
					UndirectedGraphNode neib = currentNode.neighbors.get(i);
					if(neib != null) {
						if(neib == b) {
							return true;
						}
						if(checkMap.get(neib) == null || !checkMap.get(neib)) {
							searchQueue.add(neib);
							checkMap.put(neib, true);
						}
					}
				}
			}
		}
		return false;
	}
}
