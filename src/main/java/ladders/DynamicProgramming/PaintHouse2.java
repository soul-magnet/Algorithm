package main.java.ladders.DynamicProgramming;
/**
 * 516. Paint House II - Hard

There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

 Notice
All costs are positive integers.

Example
Given n = 3, k = 3, costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

house 0 is color 2, house 1 is color 3, house 2 is color 2, 2 + 5 + 3 = 10

Challenge 
Could you solve it in O(nk)?

Tags: Dynamic Programming Facebook

Related Problems 
Hard Sliding Window Median 18 %
Medium Paint House 35 %
Easy Paint Fence 30 %
Super Sliding Window Maximum 27 %
Easy Product of Array Exclude Itself 27 %
 * */
public class PaintHouse2 {
	 /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
          if(costs==null||costs.length==0||costs[0].length==0){
            return 0;
        }
        int len = costs.length;
        int k= costs[0].length;
        int dp[] = new int [k];
        int min1 = Integer.MAX_VALUE;; int min2 = Integer.MAX_VALUE;;
        for(int i =0 ; i<k; i++){
            dp[i]=costs[0][i];
            if(dp[i]<=min1){
                min2 = min1;
                min1=dp[i];
            }else  if(dp[i]<=min2){
                min2=dp[i];
            }
        }
        int pre_min1= min1;
        int pre_min2= min2;
        for(int i =1 ; i<len; i++){
             pre_min1= min1;
             pre_min2= min2;
             min1 = Integer.MAX_VALUE;
             min2 = Integer.MAX_VALUE;

            for(int j =0 ; j<k; j++){
                if(dp[j]!=pre_min1||pre_min1==pre_min2){
                    dp[j] =pre_min1+ costs[i][j];
                }else{
                    dp[j] =pre_min2+ costs[i][j];
                }
                if(dp[j]<=min1){
                    min2 = min1;
                    min1=dp[j];
                }else  if(dp[j]<min2){
                    min2=dp[j];
                }
            }

        }
        return  min1;
    }

}
