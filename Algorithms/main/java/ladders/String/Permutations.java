package String;

import java.util.ArrayList;

/*
 * Given a list of numbers, return all possible permutations.
 * Have you met this question in a real interview? Yes
 * Example
 * For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

Analysis: 
Fixing characters in certain position & determining permutation in rest
- Formalize the process:
- Choose the first character 
- Obtain all permutations with first character fixed 
	- Choose second character
	- Obtain all permutations with first and second character fixed --> Recursion
- Choosing characters;
- Character picked in previous recursion cannot be choosen again
- Scan previous chosen character 

Algorithm:

If we picked all the characters in string
	print permutation
else 
	for each character in string 
		if character already used
			skip character
		else 
			place character in current position
			mark character as used
			permute remaining characters starting from position + 1
			unmark character
*/

//Challenge
//Do it without recursion.

// First version is Recursion 
// Second version is Iterative
public class Permutations {
	// Recursion 
	/*public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0){
			return result;
		}
		
		helper(nums, result, new ArrayList<Integer>());
		return result;
		
		
	}
	
	public void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer>cur){
		if (cur.size() == nums.size()) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for (int j = 0; j < nums.size(); j++) {
			if (cur.contains(nums.get(j))){
				continue;
			}
			cur.add(nums.get(j));
			helper(nums, result, cur);
			cur.remove(cur.size() - 1);
		}
	}*/
	
	// Iterative
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return result;
		}
		
		// start from an empty list
		result.add(new ArrayList<Integer>());
		
		// add nums[i] to all positions of each list in the current result => new result
		for (int i = 0; i < nums.size(); i++) {
			ArrayList<ArrayList<Integer>> nextResult = new ArrayList<ArrayList<Integer>>();
			
			// for each list L in the result
			for (ArrayList<Integer> l : result){
				// insert num[i] from ) to L.size()
				for (int j = 0; j < l.size() + 1; j++){
					l.add(j, nums.get(i));
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
    				nextResult.add(temp); //add the new list to the next result.
    				l.remove(j);
				}
			}
			result = nextResult;
		}
		
		return result;
	}
	
	
}
