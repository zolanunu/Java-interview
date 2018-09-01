/**
 * 
 */
package com.leetcode;

/**
 * @author zolanunu
 *
 */
public class NumComberAll {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,3,3,2,2,4,1,4,-2,5,1};
		String b = "";
		fun(a, b, 11, 0, 5);
	}
	//递归搜索
	public static void fun(int a[],String b, int length, int  i, int s)
	{
		String temp = b;
		if(i>=length)
			return;
		//输出
		if(s==0)
			System.out.println(temp);
		//不取a[i]
		fun(a,temp, length, i+1, s);
		//取a[i]
		temp=temp+a[i];
		fun(a,temp, length, i+1, s-a[i]);
	}

}
