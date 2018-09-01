package com.leetcode;


public class ShellSort {
	/**
	 * 希尔排序也成为“缩小增量排序”，其基本原理是，现将待排序的数组元素分成多个子序列
	 * 使得每个子序列的元素个数相对较少，然后对各个子序列分别进行直接插入排序
	 * 待整个待排序列“基本有序”后，最后在对所有元素进行一次直接插入排序
	 * 因此，我们要采用跳跃分割的策略：将相距某个“增量”的记录组成一个子序列
	 * 这样才能保证在子序列内分别进行直接插入排序后得到的结果是基本有序
	 * 而不是局部有序。希尔排序是对直接插入排序算法的优化和升级。 
	 * 所谓的基本有序，就是小的关键字基本在前面，大的基本在后面，不大不小的基本在中间
	 * 例如｛2,1,3,6,4,7,5,8,9,｝就可以称为基本有序了。
	 * 但像｛1,5,9,3,7,8,2,4,6｝这样，9在第三位，2在倒数第三位就谈不上基本有序。
	 * 
	 * 最好和平均复杂度 nlogn  最坏： n^2
	 * **/
	public static int[] shellSort(int[] a) {
		int j = 0;
		int temp = 0;
		for(int increment = a.length / 2; increment > 0; increment /= 2) {
			System.out.println("increment: " + increment);
			for(int i = increment; i < a.length; i++) {
				temp = a[i];
				for(j = i - increment; j >= 0; j -= increment) {
					if(temp < a[j]) {
						a[j+increment] = a[j];
					} else {
						break;
					}
				}
				a[j+increment] = temp;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int[] a = {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
		a = shellSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
}
