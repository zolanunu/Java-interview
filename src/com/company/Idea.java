package com.company;

public class Idea implements Comparable<Idea> {
	int id; // ���
	int submit_time; // �����ʱ��
	int need_time; // ����ʱ��
	int priority; // ���ȼ�
	boolean isDone; // �Ƿ����
	
	public int compareTo(Idea o) {
		return o.priority==priority ? (o.need_time==need_time ? o.id-id:o.need_time-need_time) : priority-o.priority;
		//
	}
	
	public Idea(int id, int submit_time, int need_time, int priority){
		this.id = id;
		this.submit_time = submit_time;
		this.need_time = need_time;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubmit_time() {
		return submit_time;
	}

	public void setSubmit_time(int submit_time) {
		this.submit_time = submit_time;
	}

	public int getNeed_time() {
		return need_time;
	}

	public void setNeed_time(int need_time) {
		this.need_time = need_time;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
