package com.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.PushBox.Point;

public class MaxPointsOnaLine {
	public int maxPoints(Point[] points) {
		/**
		 * ��άƽ���ϸ������ɸ��㣬�жϹ��ߵĵ���������
		 * */
		
		if(points.length<3) {
			return points.length;
		}
		int max = 0;
		Map<Double, Integer> map = new HashMap<Double, Integer>();//����ͬһ��б�ʵĵ�ĸ���
		for(int i = 0; i < points.length; i++) {
			// ��ÿһ����Ϊ�̶���
			map.clear();
			int duplicate = 1; // ��¼�͹̶����غϵĸ���
			for(int j = 0; j < points.length; j++) {
				if(i==j) {
					continue; // ���Լ���������
				}
				double slope = 0.0; // ��¼����֮���б��
				if (points[i].x==points[j].x&&points[i].y==points[j].y) {
					duplicate++;
					continue;
				} else if(points[i].x==points[j].x) {
					// �͹̶�����ͬһ�������ϣ�б��Ϊ���ֵ
					slope = Integer.MAX_VALUE;
				} else {
					slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
				}
				map.put(slope, map.containsKey(slope)?map.get(slope)+1:1);
			}
			if(map.keySet().size()==0) { // ���map�ǿյĻ�����˵��ȫ����Ҫ���غ��˰�
				max = duplicate > max ? duplicate : max;
			} else {
				for(double key : map.keySet()) {
					max = Math.max(duplicate+map.get(key), max);
				}
			}
		}
		return max;
	}
}
