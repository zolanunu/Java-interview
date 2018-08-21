package com.java.java_base;

public class Test {
	public static void main(String[] args) {
		Worker employee = new Employee("Frank");// 定义一个员工
		Boss boss = new Boss(employee);// 定义一个Boss 
		
		// boss开始下达任务
		boss.sendTask();
		// 这是一个简单的同步回调的例子
		// Boss通过Worker接口可以给员工安排工作，而不用去关心是哪个员工在工作
		// Worker通过ReceiveReport来向Boss报告工作情况，两个类通过接口进行回调交互
		// 可以很好的解耦合，因为Boss可以安排不同的员工，只要他们实现了Worker接口就行
		// 而员工也可以向不同的boss汇报情况，只要实现了ReceiveReport接口即可。
		
	}
	
}
