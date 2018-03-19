package main.java.ladders.Array;
/**
 * 150. Best Time to Buy and Sell Stock II - Medium
e
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).

Example
Given an example [2,1,2,0,1], return 2

Tags 
Enumeration Greedy Array
Related Problems 
Hard Best Time to Buy and Sell Stock IV 25 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
 * */
public class BestTimeToBuyAndSellStock2 {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
          if(prices==null&& prices.length!=0 ){
            return 0;
        }
        int profit=0;
        for(int i= 1; i<prices.length;i++){
            profit+= Math.max(0,prices[i]-prices[i-1]);
        }
        return profit;
    }
}
