package com.java.java_base;

public class Test {
	public static void main(String[] args) {
		Worker employee = new Employee("Frank");// ����һ��Ա��
		Boss boss = new Boss(employee);// ����һ��Boss 
		
		// boss��ʼ�´�����
		boss.sendTask();
		// ����һ���򵥵�ͬ���ص�������
		// Bossͨ��Worker�ӿڿ��Ը�Ա�����Ź�����������ȥ�������ĸ�Ա���ڹ���
		// Workerͨ��ReceiveReport����Boss���湤�������������ͨ���ӿڽ��лص�����
		// ���ԺܺõĽ���ϣ���ΪBoss���԰��Ų�ͬ��Ա����ֻҪ����ʵ����Worker�ӿھ���
		// ��Ա��Ҳ������ͬ��boss�㱨�����ֻҪʵ����ReceiveReport�ӿڼ��ɡ�
		
	}
	
}
