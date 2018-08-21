/**
 * 
 */
package com.java.leetcode.coding;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class PlayCardsNiuNiu {
	/**
	 * ţţ�����������ģ����ó��˿�����������Ϸ����Ϸ�Ĺ���ܼ򵥣������������ȡ�����ƣ�
	 * �����Ƶ����ֺ�����ȡʤ�����˿���������Ϊ52�ţ�û�д�С����A=1��J=11��Q=12��K=13��
	 * ÿ�������������ƣ������������Ѿ��ֱ��������Լ���ǰ�����ƣ�ţţ��Ҫ֪���Լ�ҪӮ����Ϸ�ĸ����ж�� 
	 * */
	
	/**
	 * ����������У���һ��������������a1��b1��c1(1��a1��b1��c1��13)��
	 * ��ʾţţ�������˿��ơ��ڶ���������������a2��b2��c2(1��a2��b2��c2��13)����ʾ�����������˿��ơ�
	 * 
	 * ���һ������x������4λС��������ʾţţ��ʤ�ĸ��ʡ�
	 * */
	
	/**
	 * ţţ����һ������ȡ����52���ƣ�����Ŀ����6���ƺ󣬻���46���ƿ���ȡ��
	 * ���ǾͰ���46����ȫ���Ž�һ���������棬Ȼ��������ѭ����
	 * ö��ţţ�������һ���Ʒֱ����ȡ��ʲô�ƣ��ܵ�ö�����Ƿ�ĸ�����Ӽ�Ϊţţ���椶��������������ɡ�
	 * */
	
	public static double getPro(int[] a1, int[] a2) {
		// ��һ����������¼ÿ�����ֵ�ץȡ����
		int[] vis = new int[15]; // ÿ���Ƶķ�����
		int[] a = new int[60]; // ��ʮ����
		int sum1 = 0, sum2 = 0;
		for(int i = 0; i < 3; i++) {
			vis[a1[i]]++;
			sum1 += a1[i];
		}
		
		for(int i = 0; i < 3; i++) {
			vis[a2[i]]++;
			sum2 += a2[i];
		}
		
		int cnt = 0;
		double l = 0, r = 0;
		for(int i = 1; i <= 13; i++) {
			for(int j = 0; j < 4-vis[i]; j++) {
				a[cnt++] = i;
			} // ��¼û��ץ������
		}
		System.out.println(cnt + " sum1 = " + sum1 + " sum2 = " + sum2);
		for(int i = 0; i < cnt; i++) {
			sum1 += a[i];
			for(int j = 0; j < cnt; j++) {
				if(i == j) {
					
					
					continue;
				}
				sum2 += a[j];
				r++;
				if(sum1 > sum2) {
					l++;
				}
				sum2 -= a[j];
			}
			sum1 -= a[i];
		}
		System.out.println("46 * 45 = " + 45*46 + " r = " + r + " l = " + l);
		//System.out.println( l / r);
		return l / r;
	}
	
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int[] a1 = new int[3];
		int[] a2 = new int[3];
		for(int i = 0; i < 3; i++) {
			a1[i] = inScanner.nextInt();
		}
		for(int i = 0; i < 3; i++) {
			a2[i] = inScanner.nextInt();
		}
		double result = getPro(a1, a2);
		DecimalFormat df = new DecimalFormat("0.0000");
		System.out.println(df.format(result));
		//System.out.println();
		inScanner.close();
	}
	
}
