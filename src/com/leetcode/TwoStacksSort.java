/**
 * 
 */
package com.leetcode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zolanunu
 * 
 */
public class TwoStacksSort {
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		Stack<Integer> A = new Stack<Integer>();
		Stack<Integer> B = new Stack<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			A.push(numbers[i]);
		}
		while (!A.isEmpty()) {
			int temp = A.pop();
			// 为什么要用&&同时判断呢，是因为如果只有!B.isEmpty()的话再用if判断 B.peek()>temp
			// 就会进入死循环当!B.isEmpty()符合当前条件的话
			while (!B.isEmpty() && B.peek() > temp) {
				A.push(B.pop());
			}
			B.push(temp);
		}

		while (!B.isEmpty()) {
			list.add(B.pop());
		}
		return list;
	}
}
