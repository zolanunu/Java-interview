package com.leetcode;

public class ConstructMultiplyArray {
	/**
	 * 构建乘积数组
	 * 给定�?个数组A[0,1,...,n-1],
	 * 请构建一个数组B[0,1,...,n-1],
	 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]�?
	 * 不能使用除法�?
	 * 
	 * 读懂题意：B中元素是A中元素除了当前位置元素的其他元素乘积
0	 * */
	
	public int[] multiply(int[] A) {
		if(A.length == 0 || A == null) {
			return A;
		}
		int n = A.length;
		int[] B = new int[n];
		for(int i = 0; i < n; i++) {
			int multiply = 1;
			for(int j = 0; j < n; j++) {
				if(i != j) {
					multiply = multiply * A[j];
				} else {
					continue;
				}
			}
			B[i] = multiply;
		}
		return B;
	}
	
	

//		解释下代码，设有数组大小�?5�?
//		对于第一个for循环
//		第一步：b[0] = 1;
//		第二步：b[1] = b[0] * a[0] = a[0]
//		第三步：b[2] = b[1] * a[1] = a[0] * a[1];
//		第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
//		第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
//		然后对于第二个for循环
//		第一�?
//		temp *= a[4] = a[4]; 
//		b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
//		第二�?
//		temp *= a[3] = a[4] * a[3];
//		b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
//		第三�?
//		temp *= a[2] = a[4] * a[3] * a[2]; 
//		b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
//		第四�?
//		temp *= a[1] = a[4] * a[3] * a[2] * a[1]; 
//		b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
//		由此可以看出从b[4]到b[0]均已经得到正确计算�??
}
