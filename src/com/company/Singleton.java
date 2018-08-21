package com.company;

public class Singleton {
	private static volatile Singleton singleton;
	// volatile 关键字主要是为了防止指令重排
	/**
	 * 分配内存空间。(1)
	 * 初始化对象。(2)
	 * 将 singleton 对象指向分配的内存地址。(3)
	 * */
	// volatile 关键字只能保证可见性，顺序性，不能保证原子性
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
