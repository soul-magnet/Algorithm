package Ladder6.DynamicProgramming_II;

import java.util.ArrayList;

/**
 * 91. Minimum Adjustment Cost - Medium - Optional

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than 
a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

 Notice
You can assume each number in the array is a positive integer and not greater than 100.


Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Tags: LintCode Copyright Backpack Dynamic Programming
Related Problems 
Medium Rogue Knight Sven 29 %
 * */
public class MinimumAdjustmentCost {
	/**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> a, int target){
        if (a == null || a.size() == 0) {
            return 0;
        }
        int len = a.size();
        int[][] dp = new int[len + 1][101];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < 101; i++)
            dp[0][i] = 0;
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < 101; j++) {// search all possible candidate dp[i-1][j] where index i-2 's value is changed to j
                //prune:the possible candidate for dp[i-1][j] must not researchable where   dp[i][j]!=Integer.MAX_VALUE;
                //f[i-1][j] = the sum of adjusted difference to the index i-2 where current a[i-2] is changed to j ,
                //so for f[i][k] is a valid candidate if  K satisfied that Math.abs(j-k) <= target
                // f[i][k] = sum of adjusted cost where value a[i-1] is changed to k
                //f[i][k] = min(f[i][k], f[i-1][j]+ Math.abs(j-k) <= target)
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k < 101; k++) {
                        if (Math.abs(k - j) <= target) {
                              dp[i][k] = Math.min(dp[i][k], dp[i-1][j] + Math.abs(k - a.get(i-1)));
                        }
                    }

                }
            }
        }
        int res= Integer.MAX_VALUE;
        for (int i = 0; i < 101; i++){
            res= Math.min(dp[len][i], res);
        }
        return res;
    }

}
