package com.leetcode;

public class ObjectPractise extends Object implements Cloneable{
	// ��ȷ�ļ̳�һ��Object��
	/**
	 * ����Object������Щ��������ÿ�����������δ�
	 * */
	private String name;
	public ObjectPractise() {
		
	}
	
	public ObjectPractise(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * ʲô�������Ҫclone
	 * @throws CloneNotSupportedException 
	 * */
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ObjectPractise dp = new ObjectPractise();
		dp.name = "zola";
		System.out.println("dp.name = " + dp.name);
		ObjectPractise bp1 = (ObjectPractise) dp.clone();
		System.out.println("bp1.name = " + bp1.name);
		System.out.println("bp1.name = " + bp1.getName());
	}
}
