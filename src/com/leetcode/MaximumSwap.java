package com.java.leetcode.coding;

import java.util.Arrays;

public class MaximumSwap {
	public static int maximumSwap(int num) {
		
		// while() {}
		
		int yu = 0;
		if(num <= 10) {
			return num;
		}
		int zheng = num;
		int count = 0;
		while(zheng != 0) {
			yu = zheng % 10;
			zheng = zheng / 10;
			count++;
		}
		zheng = num;
		int[] list = new int[count];
		//System.out.println("count:" + count);
		int i = 0;
		while(zheng != 0) {
			yu = zheng % 10;
			zheng = zheng / 10;
			list[i] = yu;
			i++;
		}
		Arrays.sort(list);
		int tmp = list[list.length-1];
		//System.out.println("list.length: " + list[list.length-1] + " list.len: " + list.length);
		for(int j = list.length-2; j >= 0; j--) {
			//System.out.println("list[j]: "+list[j]);
			tmp = list[j] + tmp * 10;
			//System.out.println("tmp: " + tmp);
		}
		return tmp;
	}
	
	public static int maximumSwap1(int num) {
		 char[] digits = Integer.toString(num).toCharArray();
	        
	        int[] buckets = new int[10];
	        for (int i = 0; i < digits.length; i++) {
	            buckets[digits[i] - '0'] = i;
	        }
	        
	        for (int i = 0; i < digits.length; i++) {      //从最高位开始
	            for (int k = 9; k > digits[i] - '0'; k--) {    // k需要比数字digits[i]大
	                if (buckets[k] > i) {     //如果k的位置在i后面
	                    char tmp = digits[i];
	                    digits[i] = digits[buckets[k]];
	                    digits[buckets[k]] = tmp;
	                    return Integer.valueOf(new String(digits));
	                }
	            }
	        }
	        
	        return num;
	}
	public static void main(String[] args) {
		int n = 2736;
		int i = maximumSwap1(n);
		System.out.println(i);
	}
}
