/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class CanPlaceFlowers {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		// �ж�001�� 100�ĸ���
		int len = flowerbed.length;
		if(n < 0 || n > len) {
			return false;
		}
		int ans = 0;
		for(int i = 0; i < len; i++) {
			if(flowerbed[i] == 1) {
				continue;
			}
			if(i > 0 && flowerbed[i-1] == 1) {
				continue;
			}
			if(i < len-1 && flowerbed[i+1] == 1) {
				continue;
			}
			ans++;
			flowerbed[i] = 1; //�����֣�Ȼ���Ϊ1
		}
		return ans >= n;
	}
	

	public static void main(String[] args) {
		int[] f = {1};
		System.out.println(canPlaceFlowers(f, 0));
	}
}
