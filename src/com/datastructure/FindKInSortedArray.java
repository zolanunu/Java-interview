package com.datastructure;

public class FindKInSortedArray {
	/**
	 * ��ָoffer������53 ��Ŀһ��
	 * ���ö��ֲ�����������������ĳ�������ֵĴ���
	 * */
	public static int getFirstK(int[] data, int k, int s, int e, int len) {
		if(s>e) {
			return -1;
		}
		int mid = (s+e)/2;
		int midData = data[mid];
		if(midData==k) {
			if((mid > 0&&data[mid-1]!=k) || mid==0) {
				return mid;
			} else {
				e = mid - 1;
			}
		} else if(midData > k) {
			e = mid - 1;
		} else {
			s=  mid + 1;
		}
		return getFirstK(data, k, s, e, len);
	}
	
	public static int getLastK(int[] data, int k, int s, int e, int len) {
		if(s > e) {
			return -1;
		}
		int mid = (s+e)/2;
		int midData = data[mid];
		if(midData == k) {
			if((mid<len-1&&data[mid+1]!=k)||mid==len-1) {
				return mid;
			} else {
				s = mid + 1;
			}
		} else if(midData < k) {
			s = mid + 1;
		} else {
			e = mid - 1;
		}
		return getLastK(data, k, s, e, len);
	}
	
	public static int getNumberOfK(int[] data, int k, int len) {
		int first = getFirstK(data, k, 0, len-1, len);
		int last = getLastK(data, k, 0, len-1, len);
		int number = 0;
		if(first > -1 && last > -1) {
			number = last - first + 1;
		}
		return number;
	}
	
	public static void main(String[] args) {
		int[] data = {1,2,3,3,3,3,4,5};
		System.out.println(getNumberOfK(data, 3, data.length));
	}
}
