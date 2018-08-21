package com.java.leetcode.coding;

public interface MyStringI {
	public void clear();
	public int length();
	public boolean isEmpty();
	public char charAt(int index);
	public MyStringI subString(int s, int e);
	public MyStringI insert(int offset, MyStringI str);
	public MyStringI delete(int s, int e);
	public MyStringI contact(MyStringI str); // 将一个字符串连接到该字符串的末尾
	public int compareTo(MyStringI str);
	// 在本字符串中，从begin位置开始，检索某一个字符串第一次出现的位置) 
	public int indexOf(MyStringI str, int begin);
	
}
