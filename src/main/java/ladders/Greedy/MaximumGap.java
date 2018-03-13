package main.java.ladders.Greedy;
/**
 * 400. Maximum Gap - Hard

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

 Notice
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Have you met this question in a real interview? Yes
Example
Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.

Challenge 
Sort is easy but will cost O(nlogn) time. Try to solve it in linear time and space.

Tags: Greedy Sort
 * */

class MaximumGap {
	   /**
	     * @param nums: an array of integers
	     * @return: the maximum difference
	     */
	    public int maximumGap(int[] nums) {
	        // write your code here
	        if (nums.length<2) return 0;
	        int minNum = -1, maxNum = -1, n = nums.length;
	        for (int i=0; i<n; ++i) {
	            minNum = min(nums[i], minNum);
	            maxNum = max(nums[i], maxNum);
	        }
	        if (maxNum==minNum) return 0;
	        int average = (maxNum-minNum)/(n-1);
	        if (average==0) ++average;
	        int[] localMin = new int[n];
	        int[] localMax = new int[n];
	        for (int i=0; i<n; ++i) {
	            localMin[i] = -1;
	            localMax[i] = -1;
	        }
	        for (int i=0; i<n; ++i) {
	            int t = (nums[i]-minNum)/average;
	            localMin[t] = min(localMin[t], nums[i]);
	            localMax[t] = max(localMax[t], nums[i]);
	        }
	        int ans = average, left = 0, right = 1;
	        while (left<n-1) {
	            while (right<n && localMin[right]==-1) ++right;
	            if (right>=n) break;
	            ans = max(ans, localMin[right]-localMax[left]);
	            left = right;
	            ++right;
	        }
	        return ans;
	    }
	    private int min(int a, int b) {
	        if (a==-1) return b;
	        else 
	            if (b==-1) return a;
	            else
	                if (a<b) return a;
	                else return b;
	    }
	    private int max(int a, int b) {
	        if (a==-1) return b;
	        else
	            if (b==-1) return a;
	            else
	                if (a>b) return a;
	                else return b;    
	    }
	}