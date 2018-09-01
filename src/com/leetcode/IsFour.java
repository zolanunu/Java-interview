/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class IsFour {
	/**
	 * 一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
	 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
	 * 判断一个数列是否可以重排之后满足要求。
	 * */
	
	/**
	 * 分类讨论下。
	 * 显然，任意数和 4 的倍数相乘，其结果仍是 4 的倍数；
	 * 显然，若存在任意数量 2 的倍数，两两之间乘起来就是 4 的倍数；
	 * 如果存在一个数不是 2 的倍数，即它是一个奇数：
	 * 放在 2 的倍数旁边，一定不符合要求；
	 * 放在 4 的倍数旁边，相乘结果仍是 4 的倍数。
	 * 因此符合要求的排列分两种情况：
	 * 存在 2 的倍数，所有 2 的倍数相邻排列，需要一个 4 的倍数连接剩下的数，奇数最多和 4 的倍数数量相等，要求 countMod4 >= countOdd
	 * 没有 2 的倍数，原本放 2 的倍数一端可以改放一个奇数，countMod4 >= countOdd - 1
	 * */
	
	public boolean isFour(int[] A) {
		return false;
	}
}
