package com.java.java_base;

public class Tests {
	public static void main(String[] args) {
		Bosses boss = new Bosses();
		//����һ��Boss
		//����ʮ��Ա��
		for (int i=0;i<10;i++) {
			Workers worker = new Employees("Employee["+i+"]");
			boss.addWorker(worker);
		}
		//boss��ʼ�´�����
		boss.sendTask("Say Hello");
	}
}
