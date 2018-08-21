package com.java.leetcode.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * ����HashMap�洢������˵㱻���ǵĴ�������Ϊdmap
 * ����List�洢���в�triple booking�Ļ����Ϊevents
 * ÿ����ӻʱ������events���жϵ�ǰ����Ѵ��ڻ�Ƿ�����ͻ��������dmap
 * ���յ������ȥ0.5�����������������
 * */
public class MyCalendarII_1 {
	private Map<Double, Integer> dMap;
	private ArrayList<int[]> events;
	
	public MyCalendarII_1() {
		dMap = new HashMap<>();
		events = new ArrayList<>();
	}
	public boolean book(int start, int end) {
		int cs = 1, ce = 1;
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i)[0] <= start && events.get(i)[1]  > start) {
				cs++;
			}
			if (events.get(i)[0] < end && events.get(i)[1] > end) {
				ce++;
			}
		}
		if (cs > 2 || ce > 2) return false;
		ArrayList<Double> addList = new ArrayList<>();
		for (double key : dMap.keySet()) {
            if (start <= key && key <= end - 0.5) {
                if (dMap.get(key) == 2) return false;
                addList.add(key);
            }
        }
		for (Double key: addList) dMap.put(key, dMap.get(key) + 1);
        if (!dMap.containsKey(start)) {
            dMap.put((double)start, cs);
        }
        if (!dMap.containsKey(end - 0.5)) {
            dMap.put(end - 0.5, ce);
        }
        events.add(new int[]{start, end});
        return true;
	}
}
