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
	 * �������� h index
	 * Hָ������Ϊһ���˵�ѧ��������nƪ�ֱ�������n�Σ���ôHָ������n��
	 * 1�����䷢�������SCI���İ����������Ӹߵ�������
	 * 2����ǰ��������������б�ֱ��ĳƪ���ĵ���Ŵ��ڸ����ı���������������ż�һ��ΪHָ��
	 * */
	/**
	 * h-index�ĵ�һ�����ޣ������������µ����������ã�����100ƪ����ֻ��10�����£�h-indexҲֻ��10.
	 * h-index�ĵڶ������ޣ����������µ��ȶ��ԡ�����100ƪ���£�ֻ��1ƪ10000�����ã���������10��h-indexҲֻ��10.
	 * h-index�������Ѷ���Խ��Խ��ġ���1ƪ���£�ֻҪ��1�����ã�h-index������1�����h-indexҪ������100������Ҫ��������100ƪ���µ����������ڵ���100��
	 * �������һ�����飬������±�������µ����ô�����ÿ��Ͱ������־���������ô��������µ�������
	 * ��ô���������ڵ���ĳ����������ƪ�����͵�������±꼰��֮�������Ͱ������֮�͡�
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
	 * �������Ź����Ժ󣬵�ĳƪ���µ�������(������=3) >= ������������������µ�ƪ������������len����������len�;Ϳ���������h��
	 * Ҫ�����h�����ʵ���Ǵ������ұ������飬��һ������������������Ϊ������ĩβ��Զ����
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
	  * ���ַ����
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
