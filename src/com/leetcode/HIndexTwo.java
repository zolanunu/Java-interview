/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author zolanunu
 *
 */
public class HIndexTwo {
	/**
	 * 文章引用 h index
	 * H指数定义为一个人的学术文章有n篇分别被引用了n次，那么H指数就是n。
	 * 1、将其发表的所有SCI论文按被引次数从高到低排序；
	 * 2、从前往后查找排序后的列表，直到某篇论文的序号大于该论文被引次数。所得序号减一即为H指数
	 * */
	/**
	 * h-index的第一个上限，是他发过文章的质量（引用）。发100篇引用只有10的文章，h-index也只有10.
	 * h-index的第二个上限，是他发文章的稳定性。发了100篇文章，只有1篇10000次引用，其他都是10，h-index也只有10.
	 * h-index上升的难度是越来越大的。第1篇文章，只要有1个引用，h-index就上升1。如果h-index要上升到100，就需要他至少有100篇文章的引用数大于等于100。
	 * 可以设计一个数组，数组的下标就是文章的引用次数，每个桶里的数字就是这个引用次数的文章的数量。
	 * 那么引用数大于等于某个数的文章篇数，就等于这个下标及其之后的所有桶内数字之和。
	 * */
	/**
	 * h-index (f) = max_i( min (f(i),i))
	 * 
	 */
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) {
			return 0;
		}
		int len = citations.length;
		int[] freq = new int[len+1];
		for(int i = 0; i < len; i++) {
			if(citations[i] >= len) {
				freq[len]++;
			} else {
				freq[citations[i]]++;
			}
		}
		int sum = 0;
		for(int i = len; i >= 0; i--) {
			sum += freq[i];
			if(sum >= i) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * 当数组排过序以后，当某篇文章的引用数(例子中=3) >= 从右往左数的这个文章的篇数（例子中用len标出），这个len就就可以拿来做h。
	 * 要让这个h最大，其实就是从左往右遍历数组，第一个符合条件的数（因为离数组末尾最远）。
	 * */
	
	 public int hIndex1(int[] citations) {
	        if (citations == null || citations.length == 0) { return 0; }
	        int len = citations.length;
	        Arrays.sort(citations);
	        for (int i = 0; i < len; i++) {
	            int times = citations[i];
	            int papers = len - i;
	            if (times >= (len - i)) { return papers; }
	        }
	        return 0;
	 }
	 /**
	  * 二分法解决
	  * */
	 public int hIndex3(int[] citations) {
	        int len = citations.length;
	        int lo = 0, hi = len-1;
	        while (lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            if (citations[mid] < (len - mid)) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	        return len - lo;
	    }
}
