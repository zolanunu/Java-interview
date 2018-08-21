package com.java.java_base;

public class Employee implements Worker {
	private String name; // Ô±¹¤ÐÕÃû
	
	public Employee(String name) {
		this.name = name;
	}
	@Override
	public void work(ReceiveReport boss) {
		// TODO Auto-generated method stub
		System.out.println(name + "is doing wotks");
		String reportString = "this work is done";
		boss.receiveReport(name, reportString);
	}
	
}
