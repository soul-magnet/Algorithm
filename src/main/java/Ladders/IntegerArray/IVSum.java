package IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in
 * S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Example: For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *  A solution set is:
 *  (-1, 0, 0, 1)
 *  (-2, -1, 1, 2)
 *  (-2, 0, 0, 2)
 *  Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
 *  (ie, a ≤ b ≤ c ≤ d)
 *  The solution set must not contain duplicate quadruplets.
 * */
public class IVSum {
	/**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     * Typical K sum problem, so time complexity is N to the power of (k-1)
     * Use HashSet to avoid from duplicates
     */
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) { 
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < num.length; i++){
			for (int j = i + 1; j < num.length; j++){
				int k = j + 1;
				int l = num.length - 1;
				
				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
					
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);
						
						if (!hashSet.contains(temp)){
							hashSet.add(temp);
							result.add(temp);
						}
						
						k++;
						l--;
					}
				}
			}
		}
		
		return result;
	
		
	}
}
