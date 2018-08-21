package com.java.java_base;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {
	public static void main(String[] args) {
		// 软引用，是在内存出现不足的时候，当JVM开始回收内存的时候
		// 会对这部分内存进行回收，否则是不会对其进行回收的
		SoftReference<String> sr = new SoftReference<String>(new String("zhangli"));
		
		System.out.println(sr.get());
		
		// 弱引用
		WeakReference<String> wr = new WeakReference<String>(new String("zhangli"));
		System.out.println(wr.get());
		System.gc();
		System.out.println(wr.get());
		
		Object obj=new Object();
		SoftReference sc = new SoftReference(obj);//这里使用了软引用...

		/*
		 *在这个期间，有可能会出现内存不足的情况发生，那么GC就会直接把所有的软引用全部清除..并释放内存空间
		 *如果内存空间足够的话，那么就GC就不会进行工作...
		 *GC的工作取决于内存的大小，以及其内部的算法,,,,
		 */
		   
		if(sc !=null){
		        //如果软引用还存在，那么直接就可以获取这个对象的相关数据...这样就实现了cache...
		        obj = sr.get();
		        System.out.println(obj);

		    }else{
		        //如果已经不存在，表示GC已经将其回收，我们需要重新实例化对象，获取数据信息...
		         System.out.println("has been cleared");
		        obj = new Object();
		        sc = new SoftReference(obj);
		}
	}
}
