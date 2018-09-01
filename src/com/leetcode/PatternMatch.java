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
		if(str.length <= s && pattern.length <= p) { // 两边都已经匹配结束，返回true
			return true;
		}
		if(str.length >= s && pattern.length <= p) {
			// 模式结束，但是字符还没有结束
			return false;
		}
		if(p+1<pattern.length&&pattern[p+1]=='*'){//当前pattern的下一个是*号时  
            
            //字符串完了  
            if(s>=str.length) return matchCore(str, s, pattern, p+2);  
            else {  
              
            if(pattern[p]==str[s]||pattern[p]=='.'){  
                //当前位置匹配完成，移动到下一个模式串  
                return matchCore(str,s+1, pattern,p+2)  
                        ||matchCore(str,s+1, pattern,p)  
                        ||matchCore(str,s, pattern,p+2);  
            }else  
                return matchCore(str, s, pattern, p+2);  
            }
        }
        //当前pattern的下一个不是*时候  
        if(s>=str.length) return false;  
        else{  
        if(str[s]==pattern[p]||pattern[p]=='.')  
            return matchCore(str, s+1, pattern, p+1);  
        }  
        return false;  
    }
	
}
