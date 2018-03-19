package main.java.ladders.Greedy;
/**
 * 117. Jump Game II - Medium - Optional

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
then 3 steps to the last index.)

Tags 
Greedy Array
Related Problems 
Medium Jump Game 37 %
 * */
/* Analysis: 
 * Have 2 for loop. j trails i. 
 * If A[j] + j >= i then you calculate new jump and result.
 * 
 * Space complexity O(n) to maintain result and minimum jumps
 * Time complexity O(n^2)
 * 
 * Reference; https://www.youtube.com/watch?v=cETfFsSTGJI
 */
//    * analysis: 
//    * use dp[len] to record the minmum steps of the curren pos
//    * init: dp[len]
//    * fun: dp[i]=min(dp[j]+1, j<i&&j+a[j]>=i)
//    * return dp(len-1)

public class JumpGame2 {
	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
	// DP Version
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        
        steps[0] = 0;
        for (int i = 1; i < A.length; i++){
        	steps[i] = Integer.MAX_VALUE;
        	for (int j = 0; j <i; j++){
        		if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i){
        			steps[i] = steps[j] + 1;
        			break;
        		}
        	}
        }
        return steps[A.length - 1];
    }
    
    // Greedy Version
    public int jump2(int[] A){
    	if (A == null || A.length == 0){
    		return -1;
    	}
    	
    	int start = 0, end = 0, jumps = 0;
    	while (end < A.length - 1){
    		jumps++;
    		int farthest = end;
    		for (int i = start; i <= end; i++){
    			if (A[i] + i > farthest){
    				farthest = A[i] + i;
    			}
    		}
    		start = end + 1;
    		end = farthest;
    	}
    	return jumps;
    }
    
    
}
