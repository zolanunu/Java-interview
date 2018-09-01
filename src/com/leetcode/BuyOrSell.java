package com.leetcode;

public class BuyOrSell {
	public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        // int i = 0;
        for(int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold+prices[i]-fee); // sell out
            hold = Math.max(hold, cash-prices[i]); // buy in
        }
        return cash;
    }
	public static void main(String[] args) {
		int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		BuyOrSell by = new BuyOrSell();
		int cash = by.maxProfit(prices, fee);
		System.out.println(cash);
	}
}
