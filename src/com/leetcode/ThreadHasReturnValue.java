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
		
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		/**
		 * Executors�࣬�ṩ��һϵ�й����������ڴ����̳߳أ����ص��̳߳ض�ʵ����ExecutorService�ӿڡ�
		 * public static ExecutorService newFixedThreadPool(int nThreads)
		 * �����̶���Ŀ�̵߳��̳߳ء�
		 * */
		List<Future> list = new ArrayList<Future>();
		for(int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " "); 
			Future f = pool.submit(c);
			list.add(f);
		}
		pool.shutdown();
		// ��ȡ���в�����������н��  
		for (Future f : list) {
		    // ��Future�����ϻ�ȡ����ķ���ֵ�������������̨  
			System.out.println(">>>" + f.get().toString()); 
		}
		Date date2 = new Date();
		
		System.out.println("-----program executing time is: " + (date2.getTime()-date1.getTime())+ "millis");
	}
}
