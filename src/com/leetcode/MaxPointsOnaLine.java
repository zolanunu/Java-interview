package com.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.PushBox.Point;

public class MaxPointsOnaLine {
	public int maxPoints(Point[] points) {
		/**
		 * 二维平面上给出若干个点，判断共线的点数最多情况
		 * */
		
		if(points.length<3) {
			return points.length;
		}
		int max = 0;
		Map<Double, Integer> map = new HashMap<Double, Integer>();//保存同一个斜率的点的个数
		for(int i = 0; i < points.length; i++) {
			// 以每一个点为固定点
			map.clear();
			int duplicate = 1; // 记录和固定点重合的个数
			for(int j = 0; j < points.length; j++) {
				if(i==j) {
					continue; // 是自己，则跳过
				}
				double slope = 0.0; // 记录两点之间的斜率
				if (points[i].x==points[j].x&&points[i].y==points[j].y) {
					duplicate++;
					continue;
				} else if(points[i].x==points[j].x) {
					// 和固定点在同一个竖线上，斜率为最大值
					slope = Integer.MAX_VALUE;
				} else {
					slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
				}
				map.put(slope, map.containsKey(slope)?map.get(slope)+1:1);
			}
			if(map.keySet().size()==0) { // 如果map是空的话，就说明全部点要不重合了吧
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
