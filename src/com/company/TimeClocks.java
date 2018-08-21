/**
 * 
 */
package com.company;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class TimeClocks {
	/**
	 * Ê±ÖÓµÄÐÞÕý
	 * */
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		String[] strings = new String[2];
		for(int i = 0; i < n; i++) {
			strings[i] = inScanner.next();
		}
		for(int i = 0; i < n; i++) {
			System.out.println(strings[i]);
		}
		for(int i = 0; i < n; i++) {
			//String s = inScanner.next();
			String[] str = strings[i].split(":");
			
			String hour = str[0];
			String minute = str[1];
			String second = str[2];
			
			if(Integer.parseInt(str[0]) > 23) {
				hour = solveHour(str[0]);
			}
			if(Integer.parseInt(str[1]) > 59) {
				minute = solveMinute(str[1]);
			}
			if(Integer.parseInt(str[0]) > 59) {
				second = solveSecond(str[0]);
			}
			System.out.println(hour+":"+minute+":"+second);
		}
		inScanner.close();
	}
	
	public static String solveHour(String s) {
		return "0"+s.charAt(1);
	}
	
	public static String solveMinute(String s) {
		return "0"+s.charAt(1);
	}
	public static String solveSecond(String s) {
		return "0"+s.charAt(1);
	}
	
}
