package com.datastructure;

public class InsertSort {

	// �򵥵Ĳ��������㷨
	public static void insertSort(int[] arr) {
		/**
		 * �������򣺽�δ����õ�Ԫ�أ����뵽�Ѿ�����õ�Ԫ���У��ڲ���������漰��Ԫ�ص��ƶ����� ����Ŀռ䣺O��1�� �ȶ��ԣ��ȶ��� ʹ�������������С��
		 * ���Ӷȷ�����O(n^2) O(n)
		 */
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int cur = arr[i]; // �������Ԫ��
			while (j >= 0 && cur < arr[j]) {
				arr[j + 1] = arr[j]; // Ԫ�غ���
				j--;
			}
			arr[j + 1] = cur;
		}
	}

	// �Ľ��汾�Ķ��ֲ�������
	public static void insertSortByBinary(int[] arr) {
		/**
		 * ���Ҳ����λ�õ�ʱ����ö��ֲ��ҵķ�ʽ
		 */

		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int left = 0;
			int right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] > cur) {
					right = mid - 1;
				} else if (arr[mid] <= cur) {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				arr[j + 1] = arr[j];
			}
			arr[left] = cur;
		}
	}

	// ϣ������:��������ĸĽ��汾���ǲ��ȶ�������
	// ����������Ѿ��ź�������ݣ�Ч�ʻ��һ��
	public static void shellSort(int[] arr) {
		/**
		 * �Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬾����㷨���� ѡ��һ����������t1��t2������tk������ti>tj��tk=1��
		 * ���������и���k�������н���k ������ ÿ�����򣬸��ݶ�Ӧ������ti�����������зָ�����ɳ���Ϊm �������У��ֱ�Ը��ӱ����ֱ�Ӳ�������
		 * ����������Ϊ1 ʱ������������Ϊһ�������������ȼ�Ϊ�������еĳ��ȡ�
		 */
		/**
		 * shell�����㷨 ����h=(h*3)+1; ���������ʽ����Knuth������ ������Ǻ��˽�Ļ���ٶ�һ�°�
		 * 
		 * @param arr
		 */
		// ���ȸ�������ĳ���ȷ�����������ֵ
		int h = 1;
		// ��h * 3 + 1�õ��������е����ֵ
		while (h <= arr.length / 3)
			h = h * 3 + 1;
		// �����������Һ�����
		while (h >= 1) {
			for (int i = h; i < arr.length; i++) {
				for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
					int temp = arr[j];
					arr[j] = arr[j - h];
					arr[j - h] = temp;
				}
			}
			h = h / 3;
		}

	}
	// ѡ������
	/**
	 * ʱ�临�Ӷȣ�O��n^2��
	 * �����ռ�:O(1)
	 * ���ȶ�
	 * */
	public static void selectSort(int[] arr) {
		// �ҵ���������С��λ��Ԫ�أ��ͺ��ʵ�λ�ý���
		if(arr==null||arr.length==0) {
			return ;
		}
		for(int i = 0; i < arr.length-1; i++) {
			int min = i;
			int j = i + 1;
			for(;j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			System.out.println(i+" " + min);
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	static int k = 2;
	static int f(int i) {
		
		k++;
		return i / k;
	}
	// ������ð������
	public static void main(String[] args) {
		int[] arr = { 4, 2, 6, 1, 7, 9, 0, 2 };
		// insertSort(arr);
		//insertSortByBinary(arr);
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(f(f(f(1000))));
	}
}
