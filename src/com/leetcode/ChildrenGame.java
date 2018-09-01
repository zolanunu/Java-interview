package com.leetcode;

public class ChildrenGame {
	/**
	 * 题目描述：首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数
	 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中
	 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友
	 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)
	 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
	 * */
	/**
	 * 解题：约瑟夫环
	 * */
	
	public static int childrenGameSolution(int n, int m) {
		if(n <= 0 || m <= 0) {
			return -1;
		}
		int ret = 0;
		for(int i = 2; i <= n; i++) {
			ret = (ret + m) % i;
		}
		return ret;
	}
	
	public int LastRemaining_Solution(int n, int m) {
		
		if(n < 1 || m < 1) {
			return -1;
		}
		int[] array = new int[n];
		
		int i = -1, step = 0, count = n;
		while(count > 0) {
			i++;
			if(array[i%n] == -1) {
				continue;
			}
			step++;
            if(step==m) {
                array[i%n]=-1;
                step = 0;
                count--;
            }
        }
        return i%n;
	}
	
	
}
