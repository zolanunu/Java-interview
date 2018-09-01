package com.leetcode;

public class ChildrenGame {
	/**
	 * ��Ŀ����������,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ����
	 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��
	 * ��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����
	 * ���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)
	 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
	 * */
	/**
	 * ���⣺Լɪ��
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
