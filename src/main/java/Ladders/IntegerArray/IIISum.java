package IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array S of n integers, are there elements 
 * a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * 
 * Analysis:
 * 

*/
public class IIISum {
	 /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
     /* 1. Naive Solution: Naive solution is 3 loops, and this gives time complexity O(n^3)
      * Apparently this is not an acceptable solution, but a discussion can start from here.
      * The solution also does not handle duplicates. Therefore, it is not only time inefficient,
      * but also incorrect. 
      * Submission Result: Output Limit Exceeded
      */
	
	/*public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// sort array
		Arrays.sort(num);
		
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> each = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] > 0) break;
			
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] + num[j] > 0 && num[j] > 0) break;
				
				for (int k = j + 1; k < num.length; k++){
					if (num[i] + num[j] + num[k] == 0){
						each.add(num[i]);
						each.add(num[j]);
						each.add(num[k]);
						result.add(each);
						each.clear();
					}
				}
			}
		}
		
		return result;
	}*/
	
	/* Better Solution:
	 * A better solution is using two pointers instead of one. 
	 * This makes time complexity of O(n^2) and to avoid duplicate, 
	 * we can take advantage if sorted arrays. 
	 * For example; move pointers by >1 to use same element only once. */
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3){
			return result;
		}
		
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++){
			if (i != 0 && num[i] == num[i -1]){
				continue; //  to skip duplicate numbers
			}
			
			int left  = i + 1;
			int right = num.length - 1;
			while (left < right){
				int sum = num[left] + num[right] + num[i];
				if (sum == 0){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(num[left]);
					temp.add(num[right]);
					result.add(temp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]){
						// to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]){
						// to skip duplicates
						right--;
					}
				} else if (sum < 0){
					left++;
				} else {
					right--;
				}
			}
		}
		
		return result;
	}
	
	// or use HashSet to avoid from duplicates
	
	/*Arrays.sort(num);
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	HashSet<ArrayList<Integer>>  set = new HashSet<ArrayList<Integer>>();
	for (int i = 0; i < num.length - 2; i++){
	    int start = i + 1;
	    int end = num.length - 1;
	    while (start < end) {
	        if (num[i] + num[start] + num[end] == 0){
	            ArrayList<Integer> oneResult = new ArrayList<Integer>();
	            oneResult.add(num[i]);
	            oneResult.add(num[start]);
	            oneResult.add(num[end]);
	            set.add(oneResult);
	            start++;
	            end--;
	        } else {
	            if (num[i] + num[start] + num[end] < 0)
                    start++;
                else
                    end--;
	        }
	    }
	}
	result.addAll(set);
	return result;*/
	
}
