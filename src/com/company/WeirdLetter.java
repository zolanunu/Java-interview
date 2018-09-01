/**
 * 
 */
package com.company;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class WeirdLetter {
	/**
	 * һ����ֵ���
	 * �����ÿ���ַ��Ŀ��
	 * �ŵ�ÿһ��ֻ���100
	 * ��������S�ʣ����ж�����
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] widths = new int[28];
		for(int i = 0; i <26; i++) {
			widths[i] = in.nextInt();
		}
		String s = in.next();
		int n = 0, len = 0;
		for(int i = 0; i < s.length(); i++) {
			int tot = widths[s.charAt(i)-'a'];
			if(len+tot>100) {
				n++;
				len = tot;
			} else {
				len+=tot;
			}
		}
		System.out.println(n+1 + " " + len);
		in.close();
	}	
}
