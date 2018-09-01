package com.leetcode;

import java.util.HashMap;

public class DegreeOfArray {
	public static int findshortestSubArray(int[] nums) {
		HashMap<Integer, int[]> map = new HashMap<>();
        int maxFre = 0;
        int minLen = Integer.MAX_VALUE;
        
        // first nums iteration: store first index, last index, occurrence and find out the maxFre
        for(int i=0; i<nums.length; i++) 
        {
            if(map.containsKey(nums[i])) // num is already in map
            {
                map.get(nums[i])[1] = i; // update this num's end index
                map.get(nums[i])[2]++;   // update this num's occurrence  
            }
            else // first time that store into map
            {
                int[] numInfo = new int[3];
                numInfo[0] = i; // store this num's begin index
                numInfo[1] = i; // store this num's end index
                numInfo[2] = 1; // store this num's occurrence
                map.put(nums[i], numInfo);
            }
            
            maxFre = Math.max(maxFre, map.get(nums[i])[2]); // update maxFre
        }
        
        // second map keys iteration: find the minLen for numbers that have maxFre
        for(int num: map.keySet())
            if(maxFre == map.get(num)[2])
                minLen = Math.min(minLen, map.get(num)[1] - map.get(num)[0] + 1);

        
        return minLen;
	}
}
