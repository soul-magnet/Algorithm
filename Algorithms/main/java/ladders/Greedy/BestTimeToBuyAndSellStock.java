package main.java.ladders.Greedy;
/**
 * 149. Best Time to Buy and Sell Stock - Medium

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.

Tags 
Enumeration Greedy Array Facebook Uber
Related Problems 
Hard Best Time to Buy and Sell Stock IV 25 %
Medium Maximum Product Subarray 30 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
 * */
public class BestTimeToBuyAndSellStock {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
       	if(prices==null||prices.length==0){
			return 0;
		}
		int min= Integer.MAX_VALUE, profit=0;
		for(int i: prices){
			min= Math.min(min, i);
			profit= Math.max(profit, i-min);
		}
		return profit;
    }
}
