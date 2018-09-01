package com.leetcode;
public interface Workers {
	public void work(String taskName);
	public void setReceiveReport(ReceiveReports boss);
	public void getReward(Double money);
	public String getName();
}
