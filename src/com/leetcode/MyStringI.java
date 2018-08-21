package com.java.leetcode.coding;

public interface MyStringI {
	public void clear();
	public int length();
	public boolean isEmpty();
	public char charAt(int index);
	public MyStringI subString(int s, int e);
	public MyStringI insert(int offset, MyStringI str);
	public MyStringI delete(int s, int e);
	public MyStringI contact(MyStringI str); // ��һ���ַ������ӵ����ַ�����ĩβ
	public int compareTo(MyStringI str);
	// �ڱ��ַ����У���beginλ�ÿ�ʼ������ĳһ���ַ�����һ�γ��ֵ�λ��) 
	public int indexOf(MyStringI str, int begin);
	
}
