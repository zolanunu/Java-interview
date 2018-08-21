package com.company;

public class Singleton {
	private static volatile Singleton singleton;
	// volatile �ؼ�����Ҫ��Ϊ�˷�ָֹ������
	/**
	 * �����ڴ�ռ䡣(1)
	 * ��ʼ������(2)
	 * �� singleton ����ָ�������ڴ��ַ��(3)
	 * */
	// volatile �ؼ���ֻ�ܱ�֤�ɼ��ԣ�˳���ԣ����ܱ�֤ԭ����
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
