package Ladder6.DynamicProgramming_II;
/**
 * 
 * 564. Backpack VI - Medium - Optional
 * 
Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations 
that add up to a positive integer target.

 Notice
A number in the array can be used multiple times in the combination. 
Different orders are counted as different combinations.

Example
Given nums = [1, 2, 4], target = 4

The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
return 6

Tags: Dynamic Programming

Related Problems 
Medium Coin Change II 30 %
Medium Backpack V 45 %
Medium Backpack IV 42 %
Hard Backpack III 54 %
Medium Backpack II 40 %
Medium Backpack 25 %
 * */
public class BackPack6 {
	
	 /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
		 int[] dp = new int[target + 1];
		        dp[0] = 1;
		
		        for (int j = 1; j < target + 1; j++) {
		            for (int i : nums) {
		                if(j>=i)
		                dp[j] += dp[j - i];
		            }
		        }
		        return dp[target];
		    }

}
