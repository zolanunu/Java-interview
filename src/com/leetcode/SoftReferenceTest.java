package com.java.java_base;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
	public static void main(String[] args) {
		// �����ã������ڴ���ֲ����ʱ�򣬵�JVM��ʼ�����ڴ��ʱ��
		// ����ⲿ���ڴ���л��գ������ǲ��������л��յ�
		SoftReference<String> sr = new SoftReference<String>(new String("zhangli"));
		
		System.out.println(sr.get());
		
		// ������
		WeakReference<String> wr = new WeakReference<String>(new String("zhangli"));
		System.out.println(wr.get());
		System.gc();
		System.out.println(wr.get());
		
		Object obj=new Object();
		SoftReference sc = new SoftReference(obj);//����ʹ����������...

		/*
		 *������ڼ䣬�п��ܻ�����ڴ治��������������ôGC�ͻ�ֱ�Ӱ����е�������ȫ�����..���ͷ��ڴ�ռ�
		 *����ڴ�ռ��㹻�Ļ�����ô��GC�Ͳ�����й���...
		 *GC�Ĺ���ȡ�����ڴ�Ĵ�С���Լ����ڲ����㷨,,,,
		 */
		   
		if(sc !=null){
		        //��������û����ڣ���ôֱ�ӾͿ��Ի�ȡ���������������...������ʵ����cache...
		        obj = sr.get();
		        System.out.println(obj);

		    }else{
		        //����Ѿ������ڣ���ʾGC�Ѿ�������գ�������Ҫ����ʵ�������󣬻�ȡ������Ϣ...
		         System.out.println("has been cleared");
		        obj = new Object();
		        sc = new SoftReference(obj);
		}
	}
}
