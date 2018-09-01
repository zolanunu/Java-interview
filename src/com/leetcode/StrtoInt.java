package com.leetcode;
public class StrtoInt {
	/**
	 * 可能的输入：
	 * 1 带符号数 
	 * 2 无符号数 
	 * 3 零 
	 * 4 空指针
	 * 5 超出表示范围 – 暂时仅仅是直接退出且设置最小 – 可以考虑此时抛个异常 
	 * 6 非法输入，比如并不是一个0-9或者+ -组成的字符串 – 对于非法输入一律返回的是Integer.MIN_VALUE
	 * */
	
	public static long strToIntegerSolution(String str) {
		// 判断输入是否合法
		if(str == null) {
			return Long.MAX_VALUE;
		}
		if(str.length() == 0) {
			return 0;
		}
		for(int i = 0; i < str.length(); i++) {
			if(!judge(str.charAt(i))) {
				return Long.MIN_VALUE;
			}
		}
		char chars[] = str.toCharArray();
		long result = 0;
		if(chars[0] == '-' || chars[0] == '+') {
			// 有符号数
			result = trans(str.substring(1));
		} else {
			// 无符号数
			result = trans(str);
		}
		if(result > 0 && chars[0] == '-') {
			result = -result;
		}
		return result;
	}
	public static long trans(String str){
        if(str.length() == 0) return 0;

        long result = 0;
        for(int i=0; i<str.length(); i++){
            result = result*10 + (str.charAt(i)-'0');
            if(result > Long.MAX_VALUE){
                result = Long.MIN_VALUE;
                break;
            }
        }
        return result;
    }

    public static boolean judge(char c){
        if(c == '-' || c == '+') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
	public static void main(String[] args) {
		String str1 = "123456";
        String str2 = "-123456";
        String str3 = "-6";
        String str4 = "-";
        String str5 = "+1";
        String str6 = "+abc";
        String str7 = null;

        System.out.println(strToIntegerSolution(str1));
        System.out.println(strToIntegerSolution(str2));
        System.out.println(strToIntegerSolution(str3));
        System.out.println(strToIntegerSolution(str4));
        System.out.println(strToIntegerSolution(str5));
        System.out.println(strToIntegerSolution(str6));
        System.out.println(strToIntegerSolution(str7));
	}
}
