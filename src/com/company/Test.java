/**
 * 
 */
package com.company;

/**
 * @author zolanunu
 *
 */
public class Test {
	public static void main(String[] args) {
		//System.out.println(shandle(1024, 256));
		int i, j, k =0;
		for(i=0,j=-1;j==0;i++,j++) {
			k++;
		}
		System.out.println(k);
		System.out.println(handle2(12354));
	}
	public static int shandle(int a, int b) {  
        if(a==0) return b;  
        if(b==0) return a;  
        int i=a^b;  
        int j=(a&b)<<1;  
        return  shandle(i,j);  
    }
	
	public static int handle2(int num) {
		int result = 0;
		int i = num;
		while(i != 0) {
			i = i / 10 * 10;
			result = result * 10 + num - i;
			i = i / 10;
			num = num / 10;
		}
		return result;
	}
}
