package main.java.ladders.DynamicProgramming;

/**
 * 91. Minimum Adjustment Cost - Medium

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

 Notice
You can assume each number in the array is a positive integer and not greater than 100.
 
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Tags: LintCode Copyright Backpack Dynamic Programming

Related Problems 
Medium Rogue Knight Sven 31 %
 * */
/*
 * Analysis: Backpack DP problem
 * 1. For each A[i]
 * 2. For each possible value curV(1 ... 100) that A[i] could be adjusted to.
 * 3. For each valid value lastV(1 ..100)that A[i - 1]could be adjusted
 * to (|curV - lastV| < target). Calculate the sum of local adjustment cost: |curV - A[i]| 
 * and the accumulative min adjustment cost for A[0 ... i] saved in minCost[lastV]
 * */
//search all possible candidate dp[i-1][j] where index i-2 's value is changed to j
//prune:the possible candidate for dp[i-1][j] must not researchable where   dp[i][j]!=Integer.MAX_VALUE;
//f[i-1][j] = the sum of adjusted difference to the index i-2 where current a[i-2] is changed to j ,
//so for f[i][k] is a valid candidate if  K satisfied that Math.abs(j-k) <= target
// f[i][k] = sum of adjusted cost where value a[i-1] is changed to k
//f[i][k] = min(f[i][k], f[i-1][j]+ Math.abs(j-k) <= target)

import java.util.ArrayList;
public class MinimumAdjusmnetCost {
	public static int minAdjustmentCost(ArrayList<Integer> A, int target){
		if (A == null || A.size() == 0)
			return 0;
		int[][]dp = new int[A.size()][101];
		
		int size = A.size();
		
		for (int i = 0; i < size; i++){
			for (int j = 1; j <= 100; j++){
				dp[i][j] = Integer.MAX_VALUE;
				if(i == 0){
					// the first element
					dp[i][j] = Math.abs(j - A.get(i));
				} else {
					for (int k = 1; k <= 100; k++){
						if (Math.abs(j - k) > target){
							continue;
						}
						int diff = Math.abs(j - A.get(i)) + dp[i - 1][k];
						dp[i][j] = Math.min(dp[i][j], diff);
					}
				}
			}
		}
		
		int ret = Integer.MAX_VALUE;
		for (int i = 1; i <= 100; i++){
			ret = Math.min(ret, dp[size - 1][i]);
		}
		return ret;
	}

}
