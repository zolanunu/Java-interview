package com.leetcode;

import java.util.ArrayList;

public class ArrayNesting {
	public static int arrayNesting(int[] nums) {
		if(nums.length == 1) {
            return 1;
        }
		ArrayList<Integer> countArrayList =new ArrayList<Integer>();
		int count = 0;
		//int len = nums.length-1;
		for(int i = 0; i < nums.length; i++) {
			int k = i;
			int c = 0;
			while(true) {
				if(!countArrayList.contains(nums[k])) {
					countArrayList.add(nums[(k)]);
					k = (nums[k])
							
							;
					System.out.println("k = " + k);
					c++;
					System.out.println("c = " + c);
				}else{
					if(c > count) {
						count = c;
					}
					c = 0;
					//System.out.println();
					countArrayList.clear();
					//System.out.println(countArrayList.size());
					break;
				}
			}
		}
		return count;
	}
	
	public int arrayNeting1(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
				int start = nums[i], count = 0;
				do{
					start = nums[start];
					count++;
					visited[start] = true;
				} while(start != nums[i]);
				res = Math.max(count, res);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2};
		System.out.println(arrayNesting(nums));
	}
}
