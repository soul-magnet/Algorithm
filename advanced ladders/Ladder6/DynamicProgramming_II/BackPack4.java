package Ladder6.DynamicProgramming_II;
/**
 * 562. Backpack IV - Medium - Optional

Given n items with size nums[i] which an integer array and all positive numbers, 
no duplicates. An integer target denotes the size of a backpack. 
Find the number of possible fill the backpack.

Each item may be chosen unlimited number of times

Example: Given candidate items [2,3,6,7] and target 7,

A solution set is: 
[7]
[2, 2, 3]
return 2

Tags: Dynamic Programming

Related Problems 
Medium Cutting a Rod 33 %
Medium Partition Equal Subset Sum 31 %
Medium Backpack VI 32 %
Medium Backpack V 45 %
Hard Backpack III 54 %
Medium Backpack II 40 %
Medium Backpack 25 %
 * */
public class BackPack4 {
	
	 /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
      public int backPackIV(int[] nums, int target) 
      {
	        int[] f = new int[target + 1];
	        f[0] = 1;
	        for (int i: nums)
	            for (int  j = i; j <= target; ++j)
	                f[j] += f[j - i];
	
	        return f[target];
	    }

}
