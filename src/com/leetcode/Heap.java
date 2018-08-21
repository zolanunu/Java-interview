package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.List;



public class Heap<T extends Comparable<T>> {
	// 堆中元素存放的集合
	public List<Integer> list = null;
	public static final boolean isMaxHeap = true;
	public static final boolean isMinHeap = false;
	private boolean flag = true; // true表示最大堆
	
	public Heap() {
		this.list = new ArrayList<Integer>();
	}
	public Heap(boolean flag) {
		this.list = new ArrayList<Integer>();
		this.flag = flag;
	}
	
	public int size() {
		return this.list.size();
	}
	
	public int peek() {
		if(list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	// 插入元素，从插入点开始向上调整堆
	public void add(int val) {
		this.list.add(val);
		int i = list.size()-1, index, parent, cur;
		while(i > 0) {
			index = (i - 1) / 2;
			parent = list.get(index);
			cur = list.get(i);
			if(flag==true && parent < cur) {
				swap(index, i);
			}
			i = index; // 向上调整成最大堆
		}
	}
	// 将堆顶元素取出，并且调整堆
	public int pop() {
		if(list.size()==0) {
			return -1;
		}
		int res = list.get(0);
		list.set(0, list.get(list.size()-1)); // 将最后一个元素放入堆顶
		list.remove(list.size()-1);
		int len = list.size()-1, i = 0;
		int left, right;
		while(i < len) {
			left = (i<<1)+1;
			right = (i<<1)+2;
			int maxIndex= i;
			if(flag == true) {
				if(left < len && list.get(left) > list.get(maxIndex)) {
					maxIndex = left;
				}
				if(right < len && list.get(right) > list.get(maxIndex)) {
					maxIndex = right;
				}
				if(maxIndex!=i) {
					swap(maxIndex, i);
					i = maxIndex;
				} else {
					break;
				}
				
			}
			
		}
		return res;
	}
	public void swap(int i, int j) {
		int temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
	}
}
