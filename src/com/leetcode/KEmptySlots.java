package com.leetcode;

import java.util.ArrayList;

public class KEmptySlots {
	public int kEmptySlots(int[] flowers, int k) {
		ArrayList<Integer> bloom = new ArrayList<>();
		for(int i = 0; i < flowers.length; i++) {
			int p = flowers[i];
			if(bloom.contains(p)) {
				bloom.add(p);
			}
			
		}
		return 0;
	}
}
