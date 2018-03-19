package main.java.ladders.HashTable;

import java.util.HashMap;

/**
 * 610. Two Sum - Difference equals to target - Medium

Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

 Notice
It's guaranteed there is only one available solution


Example
Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)

Tags: Hash Table Two Pointers
Related Problems 
Medium Two Sum - BST edtion 27 %
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
 * */
public class TwoSumDIfferenceEqTarget {
	/*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        int [] res= new int[2];
        if(nums==null||nums.length==0)return res;
        HashMap<Integer,Integer> hm= new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]+target)){
                res[0]= hm.get(nums[i]+target);
                res[1]=i+1;
                return res;
            }
            if(hm.containsKey(nums[i]-target)){
                res[0]= hm.get(nums[i]-target);
                res[1]=i+1;
                return res;
            }
            hm.put(nums[i], i+1);
        }
        return res;
    }

}
