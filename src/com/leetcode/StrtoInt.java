package com.leetcode;
public class StrtoInt {
	/**
	 * ���ܵ����룺
	 * 1 �������� 
	 * 2 �޷����� 
	 * 3 �� 
	 * 4 ��ָ��
	 * 5 ������ʾ��Χ �C ��ʱ������ֱ���˳���������С �C ���Կ��Ǵ�ʱ�׸��쳣 
	 * 6 �Ƿ����룬���粢����һ��0-9����+ -��ɵ��ַ��� �C ���ڷǷ�����һ�ɷ��ص���Integer.MIN_VALUE
	 * */
	
	public static long strToIntegerSolution(String str) {
		// �ж������Ƿ�Ϸ�
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
			// �з�����
			result = trans(str.substring(1));
		} else {
			// �޷�����
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
