package com.leetcode;


public class SeqString implements MyStringI {
	/**
	 * ��ε���汾�����ݽṹ��˳��ʵ��
	 * */
	private char[] strvalue;
	private int curLen; // ���ĵ�ǰ����
	public SeqString() {
		this.strvalue = new char[0];
		this.curLen = 0;
	}
	// ���췽����������˳��洢�Ĵ�����󳤶�
	public SeqString(int maxSize) {
		this.strvalue = new char[maxSize];
		this.curLen = 0;
	}
	
	public SeqString(String str) {
		strvalue = str.toCharArray();
		curLen = strvalue.length;
	}
	
	public SeqString(char[] value) {
		this.strvalue = new char[value.length];
		for(int i = 0; i < value.length; i++) {
			strvalue[i] = value[i];
		}
		curLen = value.length;
	}
	public char[] getStrValue() {
		return strvalue;
	}
	
	public int getCurlen() {
		return curLen;
	}
	
	public void clear() {
		this.curLen = 0; // ΪʲôֻҪ�ѳ�����Ϊ0��������ء������Ԫ�ػ��Ǵ��ڵİ���
	}
	/**
	 * 
	 * 
	 * */
	
	public boolean isEmpty() {
		return this.curLen == 0;
	}
	
	public int length() {
		return this.curLen;
	}
	
	public char charAt(int index) {
		if(index < 0 || index >= this.curLen) {
			throw new StringIndexOutOfBoundsException();
		}
		return strvalue[index];
	}
	
	public void allocate(int capacity) {
		char[] tempArray = this.strvalue;
		strvalue = new char[capacity];
		for(int i = 0; i < tempArray.length; i++) {
			strvalue[i] = tempArray[i];
		}
	}
	
	public MyStringI subString(int begin, int end) {
		if(begin < 0 || end > curLen || begin > end) {
			throw new StringIndexOutOfBoundsException();
		}
		if(begin == 0 && end == curLen) {
			return this;
		} else {
			char[] buffer = new char[end-begin];
			for(int i = 0; i < buffer.length; i++) {
				buffer[i] = this.strvalue[i+begin];
			}
			return new SeqString(buffer);
		}
	}
	@Override
	public MyStringI insert(int offset, MyStringI str) {
		// TODO Auto-generated method stub
		// ��offsetλ�ú����str�ַ�
		if(offset < 0 || offset > curLen) {
			throw new StringIndexOutOfBoundsException();
		}
		int strLen = str.length();
		int newLength = strLen + curLen;
		if(newLength > this.strvalue.length) {
			allocate(newLength);
		}
		// �Ƚ�offset����ַ�����
		for(int i = curLen-1; i >= offset; i--) {
			strvalue[strLen+i] = strvalue[i];
		}
		for(int i = 0; i < strLen; i++) {
			strvalue[offset+i] = str.charAt(i);
		}
		this.curLen = newLength;
		return this;
	}
	
	@Override
	public MyStringI delete(int s, int e) {
		// TODO Auto-generated method stub
		if(s<0||e>curLen||s>e) {
			throw new StringIndexOutOfBoundsException();
		}
		// Ȼ��end�Ժ󣨰���end�����ַ�����ǰ�ƶ�����ʼ��λ�á� 
		// ���ǵ�Ԫ�ַ�
		for(int i = e; i < curLen; i++) {
			this.strvalue[s+i] = this.strvalue[i];
		}
		curLen = curLen - (e-s);
		
		return this;
	}
	@Override
	public MyStringI contact(MyStringI str) {
		// TODO Auto-generated method stub
		int newL = str.length()+curLen;
		if(newL > strvalue.length) {
			allocate(newL);
		}
		for(int i = 0; i < str.length(); i++) {
			strvalue[curLen+i] = str.charAt(i);
		}
		return this;
	}
	
	
	@Override
	public int compareTo(MyStringI str) {
		// TODO Auto-generated method stub
		// * ������һ������С��Ϊ��׼�������Ƚϣ�
		// һ�����ֲ���ȣ����رȽ�ֵ��
		// ���������ͬ�Ĳ��ֶ���ȣ����س��ȱȽ�ֵ
		int len1 = curLen;
		int len2 = str.length();
		int n = Math.min(len1, len2);
		char[] cArr1 = strvalue;
		char[] cArr2 = ((SeqString)str).strvalue;
		
		int i = 0;
		char c1, c2;
		while(i < n) {
			c1 = cArr1[i];
			c2 = cArr2[i];
			if(c1!=c2) {
				return c1-c2;
			}
			i++;
		}
		return len1-len2;
	}
	@Override
	public int indexOf(MyStringI str, int begin) {
		// TODO Auto-generated method stub
		
		return 0;
	}
		
}
