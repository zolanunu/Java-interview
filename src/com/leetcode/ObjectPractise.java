package com.leetcode;

public class ObjectPractise extends Object implements Cloneable{
	// 明确的继承一个Object类
	/**
	 * 回忆Object中有哪些方法，及每个方法的修饰词
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
	 * 什么情况下需要clone
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
