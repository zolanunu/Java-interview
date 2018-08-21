package com.company;

import java.util.Scanner;

public class DollGame {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();//人数
		int m = in.nextInt();//玩偶数
		int k = in.nextInt();//位置
		if(k==0||k>n) {
		System.out.print(0);
		} else {
			k=k-1;
			int[] count=new int[n];
			for(int i=0;i<n;i++) {
				count[i]=0;
			}
			while(m!=0) {
				if((k<=0||count[k]==count[k-1])&&(k>=n-1||count[k]==count[k+1])) {
					count[k]=count[k]+1;
					m-=1;
				}
		
				if(m!=0&&(k>0&&count[k]>count[k-1])) {
					dispatchLeft(count,k-1);
					m-=1;
				}
		
				if(m!=0&&(k<n-1&&count[k]>count[k+1])) {
					dispatchRight(count,k+1);
					m-=1;
				}
			}
			System.out.print(count[k]);
		}
		in.close();
	}

	public static void dispatchLeft(int[] c,int p) {
		if(p==0||c[p-1]==c[p]) {
			c[p]=c[p]+1;
			return;
		}
		dispatchLeft(c,p-1);
	}

	public static void dispatchRight(int[] c,int p) {
		if(p==c.length-1||c[p+1]==c[p]) {
			c[p]+=1;
			return;
		}
		dispatchRight(c,p+1);
	}
}
