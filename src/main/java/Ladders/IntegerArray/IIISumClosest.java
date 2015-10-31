package IntegerArray;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target. 
 * Return the sum of the three integers.
 * For example, given array S = {-1 2 1 -4}, and target = 1. 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Note: You may assume that each input would have exactly one solution.
 * Challenge: O(n^2) time, O(1) extra space

*/
public class IIISumClosest {
	 /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    /*public int threeSumClosest(int[] numbers ,int target) {
    	if (numbers == null || numbers.length == 0){
            return -1;
        }
    	
    	int sum = numbers[0] + numbers[1] + numbers[2];
    	int diff = Math.abs(sum - target);
    	Arrays.sort(numbers);
    	for (int i = 0; i < numbers.length - 2; i++){
    		int start = i + 1;
    		int end = numbers.length - 1;
    		while (start < end){
    			int newSum = numbers[i] + numbers[start] + numbers[end];
    			int newDiff = Math.abs(newSum - target);
    			if (newDiff < diff){
    				diff = newDiff;
    				sum = newSum;
    			}
    			if(sum <  target)
    				start++;
    			else
    				end--;
    		}
    	}
    	return sum;
    	
    }*/
    
    // Second Solution 
    
    public int threeSumClosest(int[] num, int target){
    	// Note: The solution object is instantiated only once 
    	// and reused by each test case
    	
    	if (num == null || num.length < 3) {
    		return Integer.MAX_VALUE;
    	}
    	
    	Arrays.sort(num);
    	int sum = Integer.MAX_VALUE; // otherwise it will overflow for operation (sum - target)
    	for (int i = 0; i < num.length - 2; i++){
    		int left = i + 1;
    		int right = num.length - 1;
    		while(left < right){
    			int newSum = num[i] + num[left] + num[right];
    			if (newSum == target){
    				return newSum;
    			} else if (sum < target){
    				left++;
    			} else {
    				right--;
    			}
    			sum = Math.abs(newSum - target) < Math.abs(sum - target) ? newSum : sum;
    		}
    	}
    	return sum;
    }
}
