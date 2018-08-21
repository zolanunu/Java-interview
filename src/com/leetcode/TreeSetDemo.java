package com.java.java_base;

import java.util.TreeSet;
/**
 * A:��Ȼ����Ҫ���Զ�������ʵ��Comparerable<T>�ӿ�  ��������дcompareTo����
 * B:�Ƚ����������Զ�������ʵ��Comparetor<t>�ӿڣ���дcompare����
 **/
public class TreeSetDemo {
	public static void main(String[] args) {
		// �������϶���
		// 1. ������Ȼ˳������
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		// ���Ԫ��
		ts.add(20);
		ts.add(18);
		ts.add(23);
		ts.add(22);
		ts.add(17);
		ts.add(24);
		ts.add(19);
		ts.add(18);
		ts.add(24);
		
		// ����
		for(int i : ts) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-----------integer end---------------");
		
		// �����洢�Զ������ļ���
		// TreeSet<Student> ss = new TreeSet<Student>();
		// �������Student�಻ʵ��Comparable�ӿڣ��ʹ���һ���Ƚ����࣬ʵ��Comparator�ӿ�
		TreeSet<Student> ssc =new TreeSet<Student>(new MyComparator());
		Student s1=new Student("zhangsan",20);
		Student s2=new Student("lis",22);
		Student s3=new Student("wangwu",24);
		Student s4=new Student("chenliu",26);
		Student s5=new Student("zhangsan",22);
		Student s6=new Student("qianqi",24);

		ssc.add(s1);
		ssc.add(s2);
		ssc.add(s3);
		ssc.add(s4);
		ssc.add(s5);
		ssc.add(s6);
		
		for(Student student : ssc) {
			System.out.println(student.getName() + "'s age is " + student.getAge());
			// ���׳��쳣����ΪStudent�಻֪��������һ�ַ�ʽ��������������Student������Ҫimplements Comparable
			// ��дcompareTo����
			// ��д�Ժ��������
		}
		// �ܽ�

	}
}
