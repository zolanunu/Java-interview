/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zolanunu
 *
 */
public class ClassesMaodu {
	/**
	 * С����һ��ѧ�����ֵ���ѧУ��ѡ��ʱ�䣬����ѡһЩ�γ�ѧϰ����֪�γ̿���ʱ�䶼��ÿ��һ������֮�ڣ�����4���Σ�����4���Σ�����2���Ρ�
	 * С������ѡ��ʱ����������ͻ��������ϣ�����ԶԿγ�ʱ����м�顣
	 * ����
	 * ��������һ������n��0<n<=100������ʾС��ѡ��������
	 * ֮������n��ѡ����Ϣ��ÿ��ѡ����Ϣ��2�����֡�
	 * ��һ�����ֱ�ʾ����ʱ�䣬����ʱ����2λ����ʾ��ǰһλ��0��4��ʾ��һ�����壬��һλ��0��9��ʾ���絽��˳��ڼ����Σ�
	 * ��12��ʾ��ݶ��������Ρ�01��ʾ���һ�ڶ����Ρ�
	 * ÿ�еڶ������ֱ�ʾ�γ̴��룬�磺204521���γ̴���Ϊ6λ���֡�����γ̴�������ظ���
	 * ���
	 * ���û�г�ͻ�γ̣����YES��
	 * ����г�ͻ�γ̣�Ҳ����ͬһ��ʱ�����һ�ڿΣ�������г�ͻ�Ŀγ̡�����ж��У���������ͬ���Ͽ�ʱ�䶼�пγ̳�ͻ��������һ�����壬
	 * ���ϵ�����ʱ���Ⱥ󣬰��������ͻ��Ϣ����ͬһ���ڣ��������ͻʱ�䣬֮�������һʱ������пγ̣�����γ̵�˳��Ϊ��������Щ�γ̳��ֵ�˳��
	 * �γ�֮���Կո�ָ�����Ҫ����ĩ�������Ŀո�
	 * */
	/**
	 * �ܼ򵥣�����map�ļ�ֵ�����ԣ����洢ʱ����Ϣ��
	 * ֵ�洢��Ӧʱ��Ŀγ���Ϣ����Ϊ���ǵ�ͬһʱ������ж��ſγ̣�����ͻ�������������ֵ��ArrayList���洢��
	 * */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, List<String>> map = new TreeMap<String, List<String>>();
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++) {
			String time = scanner.next();
			String code = scanner.next();
			if(!map.containsKey(time)) {
				map.put(time, new ArrayList<String>());
			}
			map.get(time).add(code);
		}
		for(String time : map.keySet()) {
			if(map.get(time).size() > 1) {
				System.out.printf(time);
				for(String code : map.get(time)) {
					System.out.print(" " + code);
				}
				System.out.println();
			}
		}
		scanner.close();
 	}
}
