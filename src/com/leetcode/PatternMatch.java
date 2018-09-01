package com.leetcode;

public class PatternMatch {
	public boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null) {
			return false;
		}
	String string = "h";
	char[] s =string.toCharArray();
 		return matchCore(str, 0, pattern, 0);
	}
	public boolean matchCore(char[] str, int s, char[] pattern, int p) {
		if(str.length <= s && pattern.length <= p) { // ���߶��Ѿ�ƥ�����������true
			return true;
		}
		if(str.length >= s && pattern.length <= p) {
			// ģʽ�����������ַ���û�н���
			return false;
		}
		if(p+1<pattern.length&&pattern[p+1]=='*'){//��ǰpattern����һ����*��ʱ  
            
            //�ַ�������  
            if(s>=str.length) return matchCore(str, s, pattern, p+2);  
            else {  
              
            if(pattern[p]==str[s]||pattern[p]=='.'){  
                //��ǰλ��ƥ����ɣ��ƶ�����һ��ģʽ��  
                return matchCore(str,s+1, pattern,p+2)  
                        ||matchCore(str,s+1, pattern,p)  
                        ||matchCore(str,s, pattern,p+2);  
            }else  
                return matchCore(str, s, pattern, p+2);  
            }
        }
        //��ǰpattern����һ������*ʱ��  
        if(s>=str.length) return false;  
        else{  
        if(str[s]==pattern[p]||pattern[p]=='.')  
            return matchCore(str, s+1, pattern, p+1);  
        }  
        return false;  
    }
	
}
