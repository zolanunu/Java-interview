package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.List;



public class Heap<T extends Comparable<T>> {
	// ����Ԫ�ش�ŵļ���
	public List<Integer> list = null;
	public static final boolean isMaxHeap = true;
	public static final boolean isMinHeap = false;
	private boolean flag = true; // true��ʾ����
	
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
	// ����Ԫ�أ��Ӳ���㿪ʼ���ϵ�����
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
			i = index; // ���ϵ���������
		}
	}
	// ���Ѷ�Ԫ��ȡ�������ҵ�����
	public int pop() {
		if(list.size()==0) {
			return -1;
		}
		int res = list.get(0);
		list.set(0, list.get(list.size()-1)); // �����һ��Ԫ�ط���Ѷ�
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
