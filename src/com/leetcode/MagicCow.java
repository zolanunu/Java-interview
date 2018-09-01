/**
 * 
 */
package com.leetcode;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class MagicCow {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A = in.nextInt();
		for(int i=0;i<n;i++){
			int now = in.nextInt();
			if(now==A) {
				A = 2*A;
			}
		}
		System.out.print(A);
	}
}
