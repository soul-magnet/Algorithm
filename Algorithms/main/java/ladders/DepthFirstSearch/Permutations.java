package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**15. Permutations - Medium - Required

Given a list of numbers, return all possible permutations.

 Notice
You can assume that there is no duplicate numbers in the list.

Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge: Do it without recursion.

Tags: LinkedIn Recursion
Related Problems 
Medium Print Numbers by Recursion 26 %
Medium Permutation Sequence 28 %
Medium Permutations II 26 %*/
public class Permutations {
	 /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
    	//Write your code here
    	List<List<Integer>>result = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length == 0) return result;
    	dfs(result, new ArrayList<>(), nums);
    	return result;
    }
    
    private void dfs(List<List<Integer>>result, ArrayList<Integer> tempList, int[] nums){
    	if(tempList.size() == nums.length){
    		result.add(new ArrayList<Integer>(tempList));
    	}
    	
    }

}
