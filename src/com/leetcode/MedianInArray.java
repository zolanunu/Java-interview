package com.java.leetcode.coding;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianInArray {
	/**
	 * 数据流中的中位数
	 * 
	 * */
	/**
	 * 插入有两种思路：
	 * 1：直接插入大堆中，之后若两堆尺寸之差大于1(也就是2)，
	 * 则从大堆中弹出堆顶元素并插入到小堆中
	 * 若两队之差不大于1，则直接插入大堆中即可。
	 * 2：奇数个数插入到大堆中，偶数个数插入到小堆中，
	 * 可能会出现当前待插入的数比小堆堆顶元素大，
	 * 此时需要将元素先插入到小堆，然后将小堆堆顶元素弹
	 * 出并插入到大堆中
	 * 对于偶数时插入小堆的情况，一样的道理。why?
	 * 因为要保证最大堆的元素要比最小堆的元素都要小。
	 * @param num
	 */
	private Heap maxHeap = new Heap(Heap.isMaxHeap);
	private Heap minHeap = new Heap(Heap.isMinHeap);
	public void Insert(Integer num) {
		// 容量为偶数
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
			//PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
			return o2.compareTo(o1);
		}
	});
	public void Insert1(Integer num) {
		count++;
		if ((count & 1) == 0) { // 判断偶数的高效写法
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
		//总数为奇数时，大顶堆堆顶就是中位数
		if((count&1)==1)
			result=maxHeap1.peek();
		else
			result=(minHeap1.peek()+maxHeap1.peek())/2.0;
		return result;
	}
}
