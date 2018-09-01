package com.leetcode;

public class QuickSort {
	public static void sort(int[] a){//��������
        sort(a, 0, a.length-1);
    }
    private static void sort(int[] a, int lo, int hi){
        if(lo >= hi)//�ݹ��˳��ж�����
            return;
        int p = partition(a, lo, hi);//����ĳһԪ�أ��䱾���ز���ݹ��ˣ���Ϊ�����ڵ�λ���Ѿ�����ǰ��Ĳ����ڣ�����Ĳ�С��
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }
    private static int partition(int[] a, int lo, int hi){
        int left = lo;//��pointer����ɨ����
        int right = hi+1;//��pointer����ɨ���ã���1��Ϊ�˷���ɨ����ƽ���
        int pivot = a[lo];

        while(true){
            while(a[++left] <= pivot)//��lo��ʼ���ҵ�����pivot��Ԫ�أ��ڷ�������ʱʹ��ǰ++����ȫ����++���ܻᷢ��Խ��
                if(left == hi)//��ֹԽ��
                    break;
            while(a[--right] >= pivot )//��hi��ʼ���ҵ�С��pivot��Ԫ��
                if(right == lo)//��ֹԽ��
                    break;
            if(left >= right)//����ɨ���ཻ�����������ж���������ȵ�ʱ��˵�����Ǻ�pivot��ȵ�Ԫ��
                break;
            swap(a, left, right);//����pivotǰ�����pivot��Ԫ�غ�pivot����С��pivot��Ԫ�أ�
            //��������Կ������������ȶ�����Ϊ����֮����ںʹ�ʱ��left����right��ȵ�Ԫ��ʱ��ԭ�е�˳��ͱ��ƻ���
        }
        swap(a, lo, right);//������Ԫ�طŵ����ʵ�λ��
//pivotδ���������ʵ�λ��֮ǰ������λ�õ�Ԫ�ض�����ɨ��������(����while����Ϊ��)��Ȼ���ٽ���һ��ɨ�裬ɨ��������Ϊ���ˣ�right<=left��right����λ�õ�Ԫ���ǲ�����pivot��
        return right;//�����з�Ԫ�ص�λ��
    }
    private static void swap(int[] a, int i, int j){
        //���ڴ��������������ظ�Ԫ��ʱ������ʹ����������ʵ�֣�����������ظ��ģ���ô�Ͳ����ԣ��ظ���Ԫ�ػᱻ��Ϊ0
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //��Ԫ����
    public static void main(String[] args) {
        int[] a = {3,4,1,9,3,2,1,6,8,4,7,5};
        sort(a);
        for (int i = 0; i < a.length; i++) 
            System.out.print(" "+a[i]+" ");
    }
}
