package main.java.ladders.Greedy;

import java.util.Arrays;

/**
 * 196. Find the Missing Number - Medium 

Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

Have you met this question in a real interview? Yes
Example
Given N = 3 and the array [0, 1, 3], return 2.

Challenge 
Do it in-place with O(1) extra memory and O(n) time.

Tags: Greedy

Related Problems 
Medium First Missing Prime Number 26 %
Medium Find the Duplicate Number 33 %
Medium Find the Missing Number II 22 %
Medium First Missing Positive 23 %
 * */
public class FindTheMissingNumber {
	/**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing1(int[] nums) {
        int len = nums.length;
        if(nums==null||len==0){
            return 0;
        }
        for(int i =0; i<len; i++){
            while(nums[i]<len&&i!=nums[i]){
                //swap nums[nums[i]] and nums[i] to put nums[i] into correct place
                int temp = nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;

            }
        }
        for(int i =0; i<len; i++){
            if(nums[i]!=i)
            return i;
        }
        return len;
    }
     public int findMissing(int[] nums) {
        Arrays.sort(nums);
        int l= 0, r = nums.length-1;
        while(l+1<r){
            int mid = l + (r-l)/2;
            if(nums[mid]>mid){
                r=mid;
            }else {
                l=mid;
            }
        }
        if(nums[l]>l){
            return l;
        }else if(nums[r]>r){
            return r;
        }else{
            return r+1;
        }
    }

}
