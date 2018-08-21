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
	 * �����left��right����̫�����壬��Ҫ�����ڽӾ������
	 * ����ջ������a������ջ�Լ����ٽ־������нڵ���ջ����ջǰ�������ж�
	 * ���õ��ھӶ�����b����õ��ջ��������������
	 * Ϊ�˷�ֹ���Ĳ������Ѿ���ջ���ĵ㲻����ջ����map����
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
