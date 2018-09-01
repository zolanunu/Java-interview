/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class ZigZag {
	/**
	 * 字符串Z字性排列，按行输出
	 * */
	public static void main(String[] args){  
        String text = "PAYPALISHIRING";
        System.out.println(text.length());
        System.out.println(method(text, 4));  
    }  
    public static String method(String s ,int numRows){
    	if(s == null || s.length() <= numRows || numRows == 1) {
    		return s;
    	}
        StringBuilder result = new StringBuilder();  
        char[] string = s.toCharArray();
        int lengthOfGroup = 2 *numRows - 2;
        for(int row = 0; row < numRows; row++) {
        	if(row == 0 || row == numRows - 1) {
        		for(int j = row; j < s.length(); j+=lengthOfGroup) {
        			result.append(string[j]);
        		}
        	} else {
        		int currentRow = row;
        		boolean flag = true;
        		int childLengthGroup1 = 2 * (numRows - 1 - row);
        		int childLengthGroup2 = lengthOfGroup - childLengthGroup1;
        		while(currentRow < s.length()) {
        			result.append(string[currentRow]);
        			if(flag) {
        				currentRow += childLengthGroup1;
        			} else {
        				currentRow += childLengthGroup2;
        			}
        			flag = !flag;
        		}
        	}
        	
        }
        return result.toString();
    }
}
