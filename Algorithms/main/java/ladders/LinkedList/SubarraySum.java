package main.java.ladders.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 138. Subarray Sum - Easy - Required

Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.

 Notice
There is at least one subarray that it's sum equals to zero.
 
Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

Tags 
Hash Table Subarray
Related Problems 
Medium Submatrix Sum 26 %
Medium Minimum Size Subarray Sum 27 %
Medium Subarray Sum Closest 21 %
 * */
public class SubarraySum {
	  /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     * 子序列的和的值 为两个定起点 的 子序列的差值
	 *O(N)的解法。使用Map 来记录index, sum的值。当遇到两个index的sum相同时，表示从index1+1到index2是一个解。
	
	注意：添加一个index = -1作为虚拟节点。这样我们才可以记录index1 = 0的解。
	
	空间复杂度：O(N)
	
	     */
    public ArrayList<Integer> subarraySum(int[] nums) {
           int len = nums.length;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // We set the index -1 sum to be 0 to let us more convient to count.
        map.put(0, -1);
        
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            
            if (map.containsKey(sum)) {
                // For example: 
                //        -3  1  2 -3 4
                // SUM: 0 -3 -2  0 -3 1
                // then we got the solution is : 0 - 2
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }
            
            // Store the key:value of sum:index.
            map.put(sum, i);
        }
        
        return res;
    }

}
