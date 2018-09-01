/**
 * 
 */
package com.leetcode;
import java.util.Arrays;



/**
 * @author zolanunu
 *
 */
public class TaskSchedular {
	public int leastInterval(char[] tasks, int n) {
		// 任务调度问题
		int[] c = new int[26];
		for (char t : tasks) {
			c[t - 'A']++;
		}
		Arrays.sort(c);
		int i = 25;
		while(i >= 0 && c[i] == c[25]) {
			i--;
		}
		return Math.max(tasks.length, (c[25]-1)*(n+1)+25-i);
	}
}
