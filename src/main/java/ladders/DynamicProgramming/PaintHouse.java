package main.java.ladders.DynamicProgramming;
/**
 * 515. Paint House - Medium

There are a row of n houses, each house can be painted with one of the three colors: 
red, blue or green. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

 Notice
All costs are positive integers.
 
Example
Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10

Tags 
LinkedIn Dynamic Programming
Related Problems 
Medium House Robber II 28 %
Hard Paint House II 26 %
Easy Paint Fence 30 %
Medium House Robber 34 %
 * */
public class PaintHouse {
	/**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost1(int[][] costs) {
            if(costs==null||costs.length==0||costs[0].length==0){
            return 0;
        }
        int len = costs.length;
        int dp[][] = new int[len][3];
        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];
        for(int i =1 ; i<len; i++){
            dp[i][0]= Math.min(dp[i-1][1]+ costs[i][0] ,dp[i-1][2]+ costs[i][0] );
            dp[i][1]= Math.min(dp[i-1][2]+ costs[i][1] ,dp[i-1][0]+ costs[i][1] );
            dp[i][2]= Math.min(dp[i-1][0]+ costs[i][2] ,dp[i-1][1]+ costs[i][2] );
        }
        return  Math.min(Math.min(dp[len-1][0],dp[len-1][1]),dp[len-1][2]);
    }
     public int minCost(int[][] costs) {
        if(costs==null||costs.length==0||costs[0].length==0){
            return 0;
        }
        int len = costs.length;
       
        int a=costs[0][0];
       int b =costs[0][1];
        int c =costs[0][2];
        for(int i =1 ; i<len; i++){
            int oldA= a;
            int oldB =b;
            int oldC=c;
            a= Math.min(oldB+ costs[i][0] ,oldC+ costs[i][0] );
           b= Math.min(oldA+ costs[i][1] ,oldC+ costs[i][1] );
           c= Math.min(oldA+ costs[i][2] ,oldB+ costs[i][2] );
        }
        return  Math.min(Math.min(a,b),c);
    }
}
