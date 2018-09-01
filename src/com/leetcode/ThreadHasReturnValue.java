package com.leetcode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadHasReturnValue {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("program starting...");
		Date date1 = new Date();
		int taskSize = 5;
		
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		/**
		 * Executors类，提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。
		 * public static ExecutorService newFixedThreadPool(int nThreads)
		 * 创建固定数目线程的线程池。
		 * */
		List<Future> list = new ArrayList<Future>();
		for(int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " "); 
			Future f = pool.submit(c);
			list.add(f);
		}
		pool.shutdown();
		// 获取所有并发任务的运行结果  
		for (Future f : list) {
		    // 从Future对象上获取任务的返回值，并输出到控制台  
			System.out.println(">>>" + f.get().toString()); 
		}
		Date date2 = new Date();
		
		System.out.println("-----program executing time is: " + (date2.getTime()-date1.getTime())+ "millis");
	}
}
