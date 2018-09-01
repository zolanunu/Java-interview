/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;

/**
 * @author zolanunu
 *
 */

/**
 * http://blog.csdn.net/feige1990/article/details/47961641
 * */

public class SetOfStacks {
	public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		ArrayList<ArrayList<Integer>> stacks = new ArrayList<>(); // 栈列表
		ArrayList<Integer> curList = null; // 当前的栈
		
		for(int i = 0; i < ope.length; i++) {
			if(ope[i][0] == 1) {
				// push操作
				if(curList == null || curList.size() == size) {
					curList = new ArrayList<>();
					curList.add(ope[i][1]);
					stacks.add(curList);
				} else {
					curList.add(ope[i][1]);
				}
			} else {
				if(curList.size() > 0) {
					curList.remove(curList.size() - 1);
				} else {
					stacks.remove(stacks.size() - 1);
					curList = stacks.get(stacks.size() - 1);
					curList.remove(curList.size() - 1);
				}
			}
		}
		return stacks;
	}
}
