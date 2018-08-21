package com.java.java_base;

import java.util.Random;

public class Employees implements Workers {
	private ReceiveReports boss;
	private String name;
	
	public Employees(String name) {
		this.name = name;
	}
	@Override
	public void work(String taskName) {
		// TODO Auto-generated method stub
		System.out.println(name + " is doing works: " + taskName);
		Random random = new Random();
		Integer time = random.nextInt(10000);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String report = "顺利完成工作";
		boss.receiveReport(this, report);
	}

	@Override
	public void setReceiveReport(ReceiveReports boss) {
		// TODO Auto-generated method stub
		this.boss = boss;
		
	}

	@Override
	public void getReward(Double money) {
		// TODO Auto-generated method stub
		System.out.println(name+"由于表现突出，获得$"+money+"现金奖励！");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}