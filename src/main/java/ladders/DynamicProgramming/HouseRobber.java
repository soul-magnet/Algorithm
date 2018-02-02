package DynamicProgramming;
/*
 You are a professional robber planning to rob houses along a street. 
 Each house has a certain amount of money stashed, the only constraint 
 stopping you from robbing each of them is that adjacent houses have 
 security system connected and it will automatically contact the police 
 if two adjacent houses were broken into on the same night.
 Given a list of non-negative integers representing 
 the amount of money of each house, determine the maximum amount of money 
 you can rob tonight without alerting the police.
 Example: Given [3, 8, 4], return 8.
 Challenge: O(n) time and O(1) memory.
 
 Analysis: Basic DP problem, description can be easily extracted as the following
 Given an array of non-negative integers, find the maximum sum of a subset, 
 such that no elements is adjacent to the each other.
 
 1. this problem requires the max sum
 2. Original index of any two elements in the subset cannot be adjacent
 
 So, from the two observation, we have some further observations:
 1. Order is not important, because we need the sum
 2. For each element(say ith element in the original array), i-1 and i+1 cannot be included
 3. SInce all numbrs are non-negative, the max sum before ith element
 say A[i], is max(A[i-2], A[i-3]).
 Why not considering A[i-4] A[i-5] ... but just the last 2 and last 3 elements?
 because A[i-2] = max(A[i-4], A[i-5]) + A[i-2], all numbers are >= 0
 So S[i-2] >= S[i-5]
 
 4. Therefore , we can write down the DP transition function 
 S[i] = max(S[i-2], S[i-3]+A[i])
 
We use S[i] denote the max sum before A[i+1], so S[1] = A[0],S[2] = A[1]
The final result is max(S[N], S[N-1]),N is the number of elements in A.
 
 */
public class HouseRobber {
	/**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
	// This solution cannot pass all the test cases 12/15 passed
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0)
        	return 0;
        int maxToPos[] = new int[A.length+1]; //the maximum amount to the i'th house
        maxToPos[0] = 0;
        maxToPos[1] = A[0];
        for (int i = 2; i < maxToPos.length; i++){
        	maxToPos[i] = Math.max(maxToPos[i-1], maxToPos[i-2]+A[i-1]);
        }
        return maxToPos[maxToPos.length-1];
    }
    
    // Another Solution
    public long houseRobber1(int[] A) {
        // write your code here
        int n = A.length;
        long []res = new long[A.length];
        long ans = 0;
        if(n==0)
            return 0;
        if(n >= 1) 
            res[0] = A[0];
        if(n >= 2)
            res[1] = Math.max(A[0], A[1]);
        if(n >= 3)
            res[2] = Math.max(A[0]+A[2], A[1]);
        if(n > 2){
            for(int i = 3; i < n; i++) {
                res[i] = Math.max(res[i-3], res[i-2])+ A[i];
            }
        }
        for(int i =0 ; i < n; i++){
            ans = Math.max(ans,res[i]);
        }
        return ans;
    }
}
