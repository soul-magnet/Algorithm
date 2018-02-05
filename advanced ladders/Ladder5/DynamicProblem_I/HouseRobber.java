package Ladder5.DynamicProblem_I;
/**
 * 392. House Robber - Medium - Required

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system 
connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example
Given [3, 8, 4], return 8.

Challenge 
O(n) time and O(1) memory.

Tags: LinkedIn Airbnb Dynamic Programming

Related Problems 
Medium House Robber III 31 %
Medium House Robber II 27 %
Medium Paint House 35 %
Easy Paint Fence 30 %
Naive Fibonacci 24 %
Easy Climbing Stairs 31 %
 * 
 * */
public class HouseRobber {
	  /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
       public long houseRobber1(int[] a) {
    	 if(a.length==0||a==null){return 0;}
    	  if(a.length==1){
			 return a[0];
		 }else if(a.length==2){
			 return Math.max(a[1], a[0]);
		 }
		 long [] dp= new long[2];
		 dp[0]= a[0]; dp[1]=a[1];
		 for(int i = 2; i< a.length; i++){
		 	dp[i%2]= Math.max(dp[(i-1)%2], dp[(i-2)%2]+a[i]);
		 }
		 return dp[(a.length-1)%2];
    }   
   public long houseRobber(int[] A) {
        int n = A.length; if(n == 0)return 0;
        long []res = new long[n+1];res[0] = 0; res[1] = A[0];
        for(int i = 2; i <= n; i++) {res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);}
        return res[n];
    }
    
     public long houseRobber2(int[] a) {
    	 if(a.length==0||a==null){
			 return 0;
		 }
		 if(a.length==1){
			 return a[0];
		 }else if(a.length==2){
			 return Math.max(a[1], a[0]);
		 }
		 long [] dp= new long[3];
		 dp[0]= a[0];
		 dp[1]=Math.max(a[1], a[0]);
		 for(int i=2;i<a.length;i++){
			 dp[i%3]=Math.max(dp[(i-1)%3], dp[(i-2)%3]+a[i]); 
			
		 }
		 return dp[(a.length-1)%3];
    }   
}
