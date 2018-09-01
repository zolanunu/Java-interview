package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
	String[] letterStrings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if(digits == null || digits.length() == 0) {
			return list;
		}
		
		for(int i = 0; i < digits.length(); i++) {
			list = letterCombinations(digits.charAt(i),list);
		}
		
		return list;
	}
	public List<String> letterCombinations(char digit, List<String> curlist) {
		int number = digit - '0';
		String letterString = letterStrings[number];
		if(letterString.length() == 0) {
			return curlist;
		}
		if(curlist.size() == 0) {
			for(int i = 0; i < letterString.length(); i++) {
				curlist.add(letterString.charAt(i)+"");
			}
			return curlist;
		}
		List<String> re = new ArrayList<String>();
		for(int i = 0; i < letterString.length(); i++) {
			for(int j = 0; j < curlist.size(); j++) {
				StringBuilder temp = new StringBuilder(letterString.charAt(i)+"");
				temp.insert(0, curlist.get(j));
				re.add(temp.toString());
			}
		}
		return re;
	}
	public List<String> letterCombinations2(String digits) {
        LinkedList<String> l = new LinkedList<String>();
        if(digits.length()==0){
            return l;
        }
        l.add("");
        
        int empty = 0;
        for(int i = 0 ; i < digits.length() ; i++){
            int number = digits.charAt(i) - '0';

            String letter = letterStrings[number];
            if(letter.length() == 0){
                empty++;
                continue;
            }
            while(l.peek().length() + empty == i){
                String peek = l.removeFirst();
                for(int j = 0 ; j<letter.length() ; j++){
                    l.add(peek+letter.charAt(j));
                }
            }    
        }
        return l;
    }
 }
