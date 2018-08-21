package com.java.leetcode.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
	public static int lengthOfSubString(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		
		int curLen = 1;
		int maxLen = 1;
		int prevIndex = 0;
		
		visited[s.charAt(0)] = 0; // 已经访问过的，标记位当前字符的下标
		
		for(int i = 1; i < s.length(); i++) {
			prevIndex = visited[s.charAt(i)];
			if(prevIndex == -1 || prevIndex + curLen < i) {
				// 第一次访问过，胡总和不在当前考虑的字串内，如果当访问第二个a时候对于第一个a就不再考虑范围内了
				curLen++; //在旧的字符串上增加
				System.out.println(i + " " +maxLen+ " " + prevIndex + " " + curLen);
			} else {
				maxLen = Math.max(maxLen, curLen);
				curLen = i - prevIndex;
				System.out.println(i + " " + maxLen + " " + prevIndex + " " +curLen);
			}
			visited[s.charAt(i)] = i;
		}
		maxLen = Math.max(maxLen, curLen);
		return maxLen;
	}
	
	public int lengthOfLongestSubstring(String s) {
	    if(s==null || s.length()==0)
	        return 0;
	    HashSet<Character> set = new HashSet<Character>();
	    int max = 0;
	    int walker = 0;
	    int runner = 0;
	    while(runner<s.length())
	    {
	        if(set.contains(s.charAt(runner)))
	        {  
	            if(max<runner-walker)
	            {  
	                max = runner-walker;
	            }  
	            while(s.charAt(walker)!=s.charAt(runner))
	            {
	                set.remove(s.charAt(walker));
	                walker++;
	            }
	            walker++;
	        }
	        else
	        {
	            set.add(s.charAt(runner));
	        }
	        runner++;
	    }
	    max = Math.max(max,runner-walker);
	    return max;  
	}
	 public int lengthOfLongestSubstring1(String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
	 public int lengthOfLongestSubstring2(String s) {
	        int n = s.length(), ans = 0;
	        int[] index = new int[128]; // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            i = Math.max(index[s.charAt(j)], i);
	            ans = Math.max(ans, j - i + 1);
	            index[s.charAt(j)] = j + 1;
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// String string = "abcabcbb";
		//System.out.println(string.charAt(0));
		// int maxLen = lengthOfSubString(string);
		// System.out.println(maxLen);
		String s = "TGGGTTCGCCTTTGATGATTTAGAAACGGTATTGCA"
				+ "GGAGGCGGAGCAGAGTGCAGCCGTTACTCATAATCGTCCAGAAGGGATTAAAGGGGCCCAGGCAACGGCG"
				+ "GCAGCGATTTACCTAGGGCGGCAGGGACGATCTAAAGCGGAGATAAAAACCTATATCGAAACCACCTTTG"
				+ "GCTATGACTTGCGTTTGAGCCTGGAAGAAATTCGGCCCCAGTATCAATTTGATAGTTCCTGCCAGGGGTC"
				+ "AGTGCCCCAGGCGATTACGGCGTTCCTAGAGTCGACAGATTTTGAGGATGCCATTCGCAATGCCGTATCT"
				+ "CTGGGAGGCGATAGCGATACCCAAGCCTGTATTGCGGGCGGTATTGCCCAAGGATTCTATGGTGGAGTGC"
				+ "CAAAACAGATTGCCCAGGAGACCTGGGCGCGATTAGATGCTGATTTGCAGCAGGTGGTAGAGGCATTTAT"
				+ "GGCAACTTACCAGATTTAATAGGTGCATTAAAGACGTATCGCGATACACCTTGCTTTTAGGTGTATTAGC"
				+ "TGAATGTACGCCAACCTCTTTCTCCAATAAGGATTAAAAGCAATACCATAAAACATCAATTCGTATCGTC"
				+ "AACTGGTATTGCGATACGGGAACCTACTTTCTCAATTTTTATGGACGTTTATATCAATCAAAAACGAGTT"
				+ "CGTCTGCGGCCTCAGCAAGCCATTGGTAAGGGGGGAGAAGCGGATGTGTATCGTCTCAATCGAACAACGG"
				+ "CGGTGAAGCTGTTTAAACCGCCCAGTCATCCAGATTTTGAGGGCATGGTTGAGGCTCAGCAGGGTGCACG"
				+ "GGAACGGTTGGCACTGCATCAGCAAAAGCTACGGCAGTTCCCCCAGTCTTTGCCTGAGCGTGTCATTTCC"
				+ "CCCCAAGCGTTGGTGATGAATCAAAATGGACAGCGCATTTTGGGCTATACGATGCCACTGCTCACCCATG"
				+ "CAGAGGTGCTGTTACGGTATTGCGATCGCCGCAGGCGGGTCAAGGACCATTGCAGAAGGCAGGTCGGAGA"
				+ "CCATCGCAAATTCCAGCAGGCGGTTGATACTCAGGCGGTAGTTGACCTGTTTTTAGATCTACACGAGACC"
				+ "GTCTCCAAGCTGCATTTTGCAGATGTGGTAATTGGGGATTTTAACGACCTCAATATTTTGGTCCAGGGCA"
				+ "CCCAGGCATTTGTGATTGATGCCGATTCATTCCAGTTTGGTTCGTTTCCCTGTTCGGTCTTTACAGCCCG"
				+ "GTTTGTCGATCCACTGCTGTGCGATCCGCAAGGGACACAACCGATATTATGTCGCCCCTATTGCTGGGAA"
				+ "TCGGATTGGTACGCCTTTACGGTGATGTTGATGCAGGCACTGCTGTTTGTTGATCCCTATGGAGGGGTTT"
				+ "ATAAACCCTCTGATCCGGCTCAGCGATTACCACAGGCGGCGCGACCACTACATCGGGTGACGGTGTTTCA"
				+ "TCCGCAGGTG";
		int len = s.length();
		System.out.println(len);
		
	}
	
}
