package com.java.java_base;

import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object> {
	private String taskNumString;
	public MyCallable() {
		// TODO Auto-generated constructor stub
	}
	public MyCallable(String taskNumString) {
		this.taskNumString = taskNumString;
	}
	
	public Object call() throws Exception {
		System.out.println(">>>" + taskNumString + "��������");
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println(">>>" + taskNumString + " ������ֹ");
		return taskNumString + "���񷵻����н������ǰ����ʱ��: " + time + "millis";
	}
}
