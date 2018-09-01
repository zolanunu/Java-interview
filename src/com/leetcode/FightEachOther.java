/**
 * 
 */
package com.leetcode;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class FightEachOther {
	/**
	 * 有n 个人排成了一行队列，每个人都有一个站立的方向：面向左或面向右
	 * 由于这n 个人中每个人都很讨厌其他的人，所以当两个人面对面站立时，
	 * 他们会发生争吵，然后其中�?个人就会被踢出队列，谁被踢出队列都是有可能的�?
	 * 我们用字符L 来表示一个面向左站立的人，用字符R 来表示一个面向右站立的人�?
	 * 那么这个队列可以用一个字符串描述。比如RLLR 就表示一个四个人的队列，
	 * 其中第一个人和第二个人是面对面站立的。他们发生争吵后队列可能会变成LLR，也可能变成RLR；若变成RLR�?
	 * 则第�?个人与第二个人还会发生争吵，队列会进�?步变成LR 或�?�RR�?
	 * */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String string = scanner.nextLine();
		
		char[] chars =  string.toCharArray();
		int r = -1;
		int l = -1;
		
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == 'R') {
				r = i;
				break;
			}
		}
		for(int i = chars.length - 1; i >= 0; i--) {
			if(chars[i] == 'L') {
				l = i;
				break;
			}
		}
		
		if(l == -1 || r == -1) {
			System.out.println(chars.length);
		} else if(r > l) {
			System.out.println(chars.length);
		} else {
			System.out.println(chars.length - (l - r));
		}
		
	}
}
