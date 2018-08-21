package com.java.java_base;


public class MainTest {
	public static void main(String[] args) {
		Other other = new Other();
		new MainTest().addOne(other);
		System.out.println(other.i);
		System.out.println(fib(7));
		System.out.println(cnt);
		
		MainTest test = new MainTest();
		test.method(null);
	}
	public void addOne(final Other other) {
		other.i++;
	}
	
	public void method(Object o) {
		System.out.println("ooo");
	}
	
	public void method(String s) {
		System.out.println("string");
	}
	static int cnt = 0;
	static int fib(int n) {
		cnt++;
		if(n==0) {
			return 1;
		} else if(n==1) {
			return 2;
		} else {
			return fib(n-1)+fib(n-2);
		}
	}
}
