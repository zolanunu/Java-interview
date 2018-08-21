/**
 * 
 */
package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zolanunu
 *
 */
public class StudentSortByArrayList {
	// 对ArrayList排序的功能
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

        Student zlj = new Student("丁晓宇", 21);
        Student dxy = new Student("赵四", 22);
        Student cjc = new Student("张三", 11);
        Student lgc = new Student("刘武", 19);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(zlj);
        studentList.add(dxy);
        studentList.add(cjc);
        studentList.add(lgc);

        System.out.println("按年龄升序：");
        Collections.sort(studentList, new SortByAge());
        for (Student student : studentList) {
         System.out.println(student.getName() + " / " + student.getAge());
        }
        System.out.println();
        System.out.println("按姓名排序：");
        Collections.sort(studentList, new SortByName());
        for (Student student : studentList) {
         System.out.println(student.getName() + " / " + student.getAge());
        }
       }
      }

      class SortByAge implements Comparator {
       public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
       if (s1.getAge() > s2.getAge())
         return 1;
        return -1;
       }
      }

      class SortByName implements Comparator {
       public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getName().compareTo(s2.getName());
       }
}
