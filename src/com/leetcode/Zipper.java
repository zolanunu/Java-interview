/**
 * 
 */
package com.java.leetcode.coding;

/**
 * @author zolanunu
 *
 */
public class Zipper {
	public String zipString(String iniString) {
		if(!countCompression(iniString)) {
			return iniString;
		}
		StringBuffer mystrBuffer = new StringBuffer();
		char last = iniString.charAt(0);
		int count = 1;
		for(int i = 1; i < iniString.length(); i++) {
			if(iniString.charAt(i) == last) {
				count++;
			} else {
				mystrBuffer.append(last);
				mystrBuffer.append(count);
				last = iniString.charAt(i);
				count = 1;
			}
		}
		mystrBuffer.append(last);
		mystrBuffer.append(count);
		return mystrBuffer.toString();
	}
	public boolean countCompression(String str) {
		if(str == null || str.length() == 0) {
			return true;
		}
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		if(size < str.length()) {
			return true; // 压缩以后不会变长
		}
		return false; // 压缩以后会变长
	}
}
