/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class GlobalAndLocalInversions {
	
	public boolean isIdealPermutation1(int[] A) {
		int cmax = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            cmax = Math.max(cmax, A[i]);
            if (cmax > A[i + 2]) return false;
        }
        return true;
	}
	
	public boolean isIdealPermutation(int[] A) {
		// time limited
		int numOfGlo = 0, numOfLoc = 0;
		numOfGlo = numberOfGlobalInversion(A);
		numOfLoc = numberOfLocalInversion(A);
		if(numOfGlo == numOfLoc) {
			return true;
		}
		return false;
	}
	
	public int numberOfGlobalInversion(int[] A) {
		int len = A.length;
		if(len == 1) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				if(A[i] > A[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public int numberOfLocalInversion(int[] A) {
		int len = A.length;
		if(len == 1) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < len-1; i++) {
			if(A[i] > A[i+1]) {
				count++;
			}
		}
		return count;
	}
}
