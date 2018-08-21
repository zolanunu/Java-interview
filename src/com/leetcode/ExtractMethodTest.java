package com.java.java_base;

public class ExtractMethodTest {
	public void me1() {
		System.out.println("first method...");
		me3();
	}
	public void me3() {
		for(int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
	}
	public void me2() {
		System.out.println("second method...");
		
	}
	public static void main(String[] args) {
		int i = 5;
		boolean b = i == 5;
		boolean b1 = b && true;
		boolean b2 = b | false;
	}
	
}
