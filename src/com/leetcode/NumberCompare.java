package com.leetcode;

import java.util.Scanner;

public class NumberCompare {
	/**
	 * 
	 * ţţ��ϲ�������ֽ��бȽϣ����Ƕ���3 > 2���ַǳ���ǵıȽϲ�����Ȥ��
	 * ���˸���֮��ѧϰ�����ֵ��ݣ���ʮ��ϲ���������ֱ�ʾ����������xy��
	 * �ɴˣ��������һ��ʮ����������ֱȽϷ�����������������x��y
	 * ����Ƚ�xy��yx�Ĵ�С�����ǰ�ߴ��ں��ߣ����">"��С�������"<"�����������"="��
	 * ��������x��y��
	 * ����1 <= x,y <= 109
	 * */
	/**
	 * ȡ�����ķ�ʽ�Ƚ�
	 * */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double suma = b * Math.log(a);
		double sumb = a * Math.log(b);
		
		if(suma>sumb) {
			System.out.println(">");
		} else if(suma<sumb) {
			System.out.println("<");
		} else {
			System.out.println("=");
		}
	}
	
	
}
