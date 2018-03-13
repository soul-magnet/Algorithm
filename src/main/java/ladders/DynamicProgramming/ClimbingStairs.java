package main.java.ladders.DynamicProgramming;
/**
 * 111. Climbing Stairs - Easy - Required

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3

Tags: Dynamic Programming
Related Problems 
Naive Fibonacci 24 %
Medium House Robber 34 %
 * */
public class ClimbingStairs {
	// Iterative way
	public int climbingStairs(int n){
		if (n <= 1)
				return n;
		int now = 0;
		int last = 1;
		int lastlast = 1;
		
		for (int i = 0; i <n ; i++){
			now  = last + lastlast;
			last = lastlast;
			last= now;
		}
		return now;
	}
	// recursive way; not efficient 
	public int climbingStairsX(int n){
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 3;
		
		return climbingStairsX(n -1) + climbingStairsX(n - 2) + climbingStairsX(n - 3);
	}
	
	//////////////////////////////
	/**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs1(int n) {
        if(n==0||n==1||n==2)
            return n;
        int [] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        
        for(int i = 3; i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }   
    public int climbStairs(int n) {
        if(n<2)
            return 1;
        int [] dp = new int[2];
        dp[0]=2;
        dp[1]=1;
        
        for(int i = 3; i<n+1;i++){
            dp[i%2] = dp[(i-1)%2]+dp[(i-2)%2];
        }
        return dp[n%2];
    }   
}
