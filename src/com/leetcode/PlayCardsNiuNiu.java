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
	 * 牛牛与妞妞闲来无聊，便拿出扑克牌来进行游戏。游戏的规则很简单，两个人随机抽取四张牌，
	 * 四张牌的数字和最大的取胜（该扑克牌总张数为52张，没有大小王，A=1，J=11，Q=12，K=13，
	 * 每种数字有四张牌），现在两人已经分别亮出了自己的前三张牌，牛牛想要知道自己要赢得游戏的概率有多大。 
	 * */
	
	/**
	 * 输入包含两行，第一行输入三个整数a1，b1，c1(1≤a1，b1，c1≤13)，
	 * 表示牛牛亮出的扑克牌。第二行输入三个整数a2，b2，c2(1≤a2，b2，c2≤13)，表示妞妞所亮出的扑克牌。
	 * 
	 * 输出一个数字x（保留4位小数），表示牛牛获胜的概率。
	 * */
	
	/**
	 * 牛牛和妞妞一共可以取得有52张牌，在题目给出6张牌后，还有46张牌可以取。
	 * 我们就把这46张牌全部放进一个数组里面，然后跑两重循环，
	 * 枚举牛牛和妞妞最后一张牌分别可以取到什么牌，总的枚举数是分母，分子即为牛牛比妞妞多的数量，相除即可。
	 * */
	
	public static double getPro(int[] a1, int[] a2) {
		// 用一个数组来记录每个数字的抓取次数
		int[] vis = new int[15]; // 每种牌的访问数
		int[] a = new int[60]; // 六十张牌
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
			} // 记录没被抓到的牌
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
