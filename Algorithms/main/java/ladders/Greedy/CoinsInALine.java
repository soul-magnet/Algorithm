package main.java.ladders.Greedy;
/**
 * 394. Coins in a Line - Medium

There are n coins in a line. 
Two players take turns to take one or two coins from right side until there are no more coins left. 
The player who take the last coin wins.

Could you please decide the first play will win or lose?

Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

Challenge 
O(n) time and O(1) memory

Tags: Greedy Array Dynamic Programming Game Theory

Related Problems 
Medium Coins in a Line II 32 %
 * */
/* 
 * Reference: http://articles.leetcode.com/2011/02/coins-in-line.html 
 * */
public class CoinsInALine {
	/**
    * @param n: an integer
    * @return: a boolean which equals to true if the first player will win
    */
	//version 1:
   public boolean firstWillWin(int n) {
       return n % 3 != 0;
   }
   
   // version 2:
   
   public boolean firstWillWin1(int n){
	   int []dp = new int[n+1];
	   return MemorySearch(n, dp);
   }
   private boolean MemorySearch(int n, int[] dp) { // 0 is empty, 1 is false, 2 is true
	   if(dp[n] != 0){
		   if(dp[n] == 1)
			   return false;
		   else
			   return true;
	   }
	   if(n <= 0){
		   dp[n] = 1;
	   } else if(n == 1) {
		   dp[n] = 2;
	   } else if (n == 2) {
		   dp[n] = 2;
	   } else if(n == 3) {
		   dp[n] = 1;
	   } else {
		   if((MemorySearch(n-2, dp) && MemorySearch(n-3, dp)) || 
	          (MemorySearch(n-3, dp) && MemorySearch(n-4, dp) )) {
	                dp[n] = 2;
	            } else {
	                dp[n] = 1;
	            }
	        }
	        if(dp[n] == 2) 
	            return true;
	        return false;
	    }
}
