package Ladder5.DynamicProblem_I;
/**
 * 393. Best Time to Buy and Sell Stock IV - Hard - Optional

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Notice
You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

Challenge 
O(nk) time.

Tags: Dynamic Programming

Related Problems 
Medium Best Time to Buy and Sell Stock III 27 %
Medium Best Time to Buy and Sell Stock II 49 %
Medium Best Time to Buy and Sell Stock 41 %
 * */
public class BestTimeToBuyAndSellStock4 {
	/**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit1(int k, int[] prices) {
        // write your code here
             if (k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int n = prices.length;
        int[][] mustsell = new int[n + 1][n + 1];   // mustSell[i][j] 表示�?i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n + 1][n + 1];  // globalbest[i][j] 表示�?i天，至多进行j次交易，第i天�?�以�?sell的最大获益
        
        mustsell[0][0] = globalbest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustsell[0][i] = globalbest[0][i] = 0;
        }
        
        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[(i - 1)][j - 1] + gainorlose,
                                            mustsell[(i - 1)][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[(i - 1)][j], mustsell[i ][j]);
            }
        }
        return globalbest[(n-1 )][k];
    }
     public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<=1||k==0){
            return 0;
        }
        if (k >= prices.length / 2) {
            int res =0;
            for(int i=1; i<prices.length;i++){
                res+=Math.max(0, prices[i]-prices[i-1]);
            }
            return res;
        }
        int[][] local= new int [prices.length][k+1];
        int[][] global= new int [prices.length][k+1];
        for(int i=0; i<k+1;i++){
            local[0][i]=global[0][i]=0;
        }
        for(int i=0; i<prices.length;i++){
            local[i][0]=global[i][0]=0;
        }
        for(int i=1; i<prices.length;i++){
            int localprofit = prices[i]-prices[i-1];
            for(int j=1; j<k+1;j++){
                local[i][j]= Math.max(global[i-1][j-1]+localprofit, local[i-1][j]+localprofit);
                global[i][j]= Math.max(global[i-1][j],local[i][j]);
            }
        }
        return global[prices.length-1][k];
    }

}
