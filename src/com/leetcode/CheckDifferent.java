/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class CheckDifferent {
	public static boolean checkDifferent(String iniString) {
		if(iniString.length() > 256) {
            return false;
        }
        boolean[] flag = new boolean[256];
        for(int i = 0; i < iniString.length(); i++) {
            int val = iniString.charAt(i);
            if(flag[val]) {
                return false;
            }
            flag[val] = true;
        }
        return true;
	}
	public static void main(String[] args) {
		String iString = "acbdbesy";
		System.out.println(checkDifferent(iString));
	}
}
