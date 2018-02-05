package Ladder6.DynamicProgramming_II;
/**
 * 563. Backpack V - Medium - Optional

Given n items with size nums[i] which an integer array and all positive numbers. 
An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is: 
[7]
[1, 3, 3]
return 2

Tags: Dynamic Programming

Related Problems 
Medium Coin Change II 30 %
Medium Backpack VI 32 %
Medium Backpack IV 42 %
Hard Backpack III 54 %
Medium Backpack II 40 %
Medium Backpack 25 %
 * */
public class BackPack5 {
	/**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0]=1;
        for (int i: nums){
            for (int j=target; j>=i;j--){
                dp[j] += dp[j-i];
            }
        }
        return dp[target];
    }

}
