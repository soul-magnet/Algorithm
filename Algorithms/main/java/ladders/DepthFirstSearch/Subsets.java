package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. Subsets - Medium - Required

Given a set of distinct integers, return all possible subsets.

 Notice
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Challenge 
Can you do it in both recursively and iteratively?

Tags: Recursion Uber Facebook

Related Problems 
Medium Smallest Subset 47 %
Easy Sum of All Subsets 16 %
Easy Split String 21 %
Medium Restore IP Addresses 24 %
Medium Subsets II 26 %
 * 
 * */
public class Subsets {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
     
     public static List<List<Integer>> subsets(int[] nums) {
    	 List<List<Integer>>result = new ArrayList<>();
    	 Arrays.sort(nums);
    	 backtrack(result, new ArrayList<Integer>(), nums, 0);
    	 return result;
     }
     
     private static void backtrack(List<List<Integer>>result, List<Integer>tempList, int[]nums, int pos) {
    	 result.add(new ArrayList<>(tempList));
    	 for(int i = pos; i < nums.length; i++) {
    		 tempList.add(nums[i]);
    		 backtrack(result, tempList, nums, i+1);
    		 tempList.remove(tempList.size() - 1);
    	 }
     }
     
     public static void main(String[] args) {
    	 int nums[] = {1, 2, 3};
    	 System.out.println(subsets(nums));
     }

}
