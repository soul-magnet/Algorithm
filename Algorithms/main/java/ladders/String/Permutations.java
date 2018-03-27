package main.java.ladders.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**15. Permutations - Medium - Required

Given a list of numbers, return all possible permutations.

 Notice: You can assume that there is no duplicate numbers in the list.

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
	/*
	 * @param nums: A list of integers
	 * @return: A list of permutations
	 * */
	//Recursive Approach - easy to implement but harder to think how recursive is actually happening
	//permutation is n! = 3! = 6
	public static List<List<Integer>> permute(int[] nums) {
		//Write your code here
		List<List<Integer>>result = new ArrayList<>();
		dfs(result, new ArrayList<Integer>(), nums);
		return result;
	}
	
	public static void dfs(List<List<Integer>>result, List<Integer>tempList, int[]nums){
		if(tempList.size() == nums.length){
			result.add(new ArrayList<>(tempList));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(tempList.contains(nums[i])) continue; //element is already exist, skip
				tempList.add(nums[i]);
				dfs(result, tempList, nums);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	///////////////////////////////////////////////////////////
	//Iterative Approach
	//throwing indexoutofbound exception
	/*public static List<List<Integer>>permute1(int[] nums){
		List<List<Integer>>result = new ArrayList<List<Integer>>();
		if(nums.length == 0) return result;
		result.add(new ArrayList<Integer>());
		for(int i = 0; i < nums.length; i++){
			List<List<Integer>>tempList = new ArrayList<List<Integer>>();
			for(int j = 0; i <= i; j++){
				for(List<Integer>l : result){
					List<Integer>newList = new ArrayList<Integer>(l);
					newList.add(nums[i]);
					tempList.add(newList);
				}
			}
			result = tempList;
		}
		
		return result;
	}*/
	
	public static List<List<Integer>> permute1(int[] num) {
	       LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	        res.add(new ArrayList<Integer>());
	        for (int n : num) {
	            int size = res.size();
	            for (; size > 0; size--) {
	                List<Integer> r = res.pollFirst();
	                for (int i = 0; i <= r.size(); i++) {
	                    List<Integer> t = new ArrayList<Integer>(r);
	                    t.add(i, n);
	                    res.add(t);
	                }
	            }
	        }
	        return res;
	        
	    }
	
	public static void main(String args[]){
		int[] nums = {1, 2, 3};
		System.out.println("recursive" + permute(nums));
		
		System.out.println("iterative" + permute1(nums));
	}
}