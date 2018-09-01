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
			// ΪʲôҪ��&&ͬʱ�ж��أ�����Ϊ���ֻ��!B.isEmpty()�Ļ�����if�ж� B.peek()>temp
			// �ͻ������ѭ����!B.isEmpty()���ϵ�ǰ�����Ļ�
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
