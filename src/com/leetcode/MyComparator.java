package com.java.java_base;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		int num = s1.getName().length() - s2.getName().length();
		// ĞÕÃûÄÚÈİ
		int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
		// ÄêÁä
		int num3 = num2 == 0 ? s1.getAge() - s2.getAge() : num2;
		return num3;
	}
	
}
