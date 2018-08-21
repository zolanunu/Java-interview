package com.java.java_base;

public class Tests {
	public static void main(String[] args) {
		Bosses boss = new Bosses();
		//定义一个Boss
		//定义十个员工
		for (int i=0;i<10;i++) {
			Workers worker = new Employees("Employee["+i+"]");
			boss.addWorker(worker);
		}
		//boss开始下达任务
		boss.sendTask("Say Hello");
	}
}
