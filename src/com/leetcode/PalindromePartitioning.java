/**
 * 
 */
package com.java.leetcode.coding;

import java.util.ArrayList;

/**
 * @author zolanunu
 *
 */
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		if(s == null || s.length() == 0) {
			return result;
		}
		calresult(result, list, s);
		return result;
	}
	
	public boolean isPalindromeString(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public void calresult(ArrayList<ArrayList<String>> result, ArrayList<String> list, String s) {
		if(s == null || s.length() == 0) {
			result.add(new ArrayList<String>(list));
		}
		int len = s.length();
		for(int i = 1; i <= len; i++) {
			String subs = s.substring(0, i);
			if(isPalindromeString(subs)) {
				list.add(subs);
				String restsubs = s.substring(i);
				calresult(result, list, restsubs);
				list.remove(list.size()-1);
			}
		}
	}
}
