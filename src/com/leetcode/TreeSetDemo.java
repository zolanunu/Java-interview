package com.java.java_base;

import java.util.TreeSet;
/**
 * A:自然排序：要在自定义类中实现Comparerable<T>接口  ，并且重写compareTo方法
 * B:比较器排序：在自定义类中实现Comparetor<t>接口，重写compare方法
 **/
public class TreeSetDemo {
	public static void main(String[] args) {
		// 创建集合对象
		// 1. 按照自然顺序排序
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		// 添加元素
		ts.add(20);
		ts.add(18);
		ts.add(23);
		ts.add(22);
		ts.add(17);
		ts.add(24);
		ts.add(19);
		ts.add(18);
		ts.add(24);
		
		// 遍历
		for(int i : ts) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-----------integer end---------------");
		
		// 建立存储自定义对象的集合
		// TreeSet<Student> ss = new TreeSet<Student>();
		// 或者如果Student类不实现Comparable接口，就创建一个比较器类，实现Comparator接口
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
			// 会抛出异常，因为Student类不知道按照哪一种方式进行排序，所以在Student类中需要implements Comparable
			// 重写compareTo方法
			// 重写以后就正常了
		}
		// 总结

	}
}
