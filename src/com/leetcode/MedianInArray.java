package com.java.leetcode.coding;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInArray {
	/**
	 * �������е���λ��
	 * 
	 * */
	/**
	 * ����������˼·��
	 * 1��ֱ�Ӳ������У�֮�������ѳߴ�֮�����1(Ҳ����2)��
	 * ��Ӵ���е����Ѷ�Ԫ�ز����뵽С����
	 * ������֮�����1����ֱ�Ӳ������м��ɡ�
	 * 2�������������뵽����У�ż���������뵽С���У�
	 * ���ܻ���ֵ�ǰ�����������С�ѶѶ�Ԫ�ش�
	 * ��ʱ��Ҫ��Ԫ���Ȳ��뵽С�ѣ�Ȼ��С�ѶѶ�Ԫ�ص�
	 * �������뵽�����
	 * ����ż��ʱ����С�ѵ������һ���ĵ���why?
	 * ��ΪҪ��֤���ѵ�Ԫ��Ҫ����С�ѵ�Ԫ�ض�ҪС��
	 * @param num
	 */
	private Heap maxHeap = new Heap(Heap.isMaxHeap);
	private Heap minHeap = new Heap(Heap.isMinHeap);
	public void Insert(Integer num) {
		// ����Ϊż��
		if( (maxHeap.size() & 1) == 0) {
			if(maxHeap.size()!=0 && num > minHeap.peek()) {
				minHeap.add(num);
				maxHeap.add(minHeap.pop());
			} else {
				maxHeap.add(num);
			}
		} else {
			if(maxHeap.size()!=0&&num <maxHeap.peek()) {
				maxHeap.add(num);
				minHeap.add(maxHeap.pop());
			} else {
				minHeap.add(num);
			}
		}
	}
	public Double getMedian() {
		double res = 0;
		if((maxHeap.size()&1)==0) {
			res = (maxHeap.peek()+minHeap.peek())/2;
		} else {
			res = maxHeap.peek();
		}
		return res;
	}
	
	int count;
	PriorityQueue<Integer> minHeap1 = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap1 = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			//PriorityQueueĬ����С���ѣ�ʵ�ִ󶥶ѣ���Ҫ��תĬ��������
			return o2.compareTo(o1);
		}
	});
	public void Insert1(Integer num) {
		count++;
		if ((count & 1) == 0) { // �ж�ż���ĸ�Чд��
		if (!maxHeap1.isEmpty() && num < maxHeap1.peek()) {
		maxHeap1.offer(num);
		num = maxHeap1.poll();
		}
		minHeap1.offer(num);
		} else {
		if (!minHeap1.isEmpty() && num > minHeap1.peek()) {
			minHeap1.offer(num);
			num = minHeap1.poll();
		}
		maxHeap1.offer(num);
		}
	}
	public Double GetMedian1() {
		if(count==0)
			throw new RuntimeException("no available number!");
		double result;
		//����Ϊ����ʱ���󶥶ѶѶ�������λ��
		if((count&1)==1)
			result=maxHeap1.peek();
		else
			result=(minHeap1.peek()+maxHeap1.peek())/2.0;
		return result;
	}
}
