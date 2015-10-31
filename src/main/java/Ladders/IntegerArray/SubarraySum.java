package IntegerArray;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 * Example:
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 * Note:
 * There is at least one subarray that it's sum equals to zero.
 * 
 * Analysis: 
 * 
 * Intuitive solution is to use O(n^2) time to consider every sub-array
 * The better solution is to use a hashmap to map <the sum from 0 to i, i>.
 * With this information, when we meet two indexes p and q with the same sum,
 * we conclude that sum of subarray [p + 1 ...q] must be zero
 * */
public class SubarraySum {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	public ArrayList<Integer> subarraySum(int[] nums) {
		int len = nums.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// we set the index -1 sum to be 0 to let us more convenient to count
		map.put(0, -1);
		int sum = 0;
		
		for (int i = 0; i < len; i++){
			sum += nums[i];
			
			if (map.containsKey(sum)){
				/*
				 * For example;
				 *        -3 1 2 -3 4
				 * Sum: 0 -3 -2 0 -3 1
				 * then we got the solution is: 0 - 2
				 * */
				result.add(map.get(sum) + 1);
				result.add(i);
				return result;
			}
			// store the key: value of sum : index
			map.put(sum, i);
		}
		return result;
	}
}
