package com.leetcode;

public class QuickSort {
	public static void sort(int[] a){//驱动程序
        sort(a, 0, a.length-1);
    }
    private static void sort(int[] a, int lo, int hi){
        if(lo >= hi)//递归退出判断条件
            return;
        int p = partition(a, lo, hi);//对于某一元素，其本身不必参与递归了，因为其所在的位置已经满足前面的不大于，后面的不小于
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }
    private static int partition(int[] a, int lo, int hi){
        int left = lo;//左pointer，供扫描用
        int right = hi+1;//右pointer，供扫描用，加1是为了方便扫描的推进，
        int pivot = a[lo];

        while(true){
            while(a[++left] <= pivot)//从lo开始，找到大于pivot的元素，在访问数组时使用前++更安全，后++可能会发生越界
                if(left == hi)//防止越界
                    break;
            while(a[--right] >= pivot )//从hi开始，找到小于pivot的元素
                if(right == lo)//防止越界
                    break;
            if(left >= right)//左右扫描相交，迭代结束判断条件，相等的时候说明就是和pivot相等的元素
                break;
            swap(a, left, right);//交换pivot前面大于pivot的元素和pivot后面小于pivot的元素，
            //从这里可以看出快速排序不稳定，因为两者之间存在和此时的left或者right相等的元素时，原有的顺序就被破坏了
        }
        swap(a, lo, right);//将枢轴元素放到合适的位置
//pivot未交换到合适的位置之前，其他位置的元素都满足扫描条件了(两个while里面为真)，然后再进行一次扫描，扫描条件均为假了，right<=left，right所在位置的元素是不大于pivot的
        return right;//返回切分元素的位置
    }
    private static void swap(int[] a, int i, int j){
        //对于待排序数组中无重复元素时，可以使用异或操作来实现，但是如果有重复的，那么就不可以，重复的元素会被置为0
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //单元测试
    public static void main(String[] args) {
        int[] a = {3,4,1,9,3,2,1,6,8,4,7,5};
        sort(a);
        for (int i = 0; i < a.length; i++) 
            System.out.print(" "+a[i]+" ");
    }
}
