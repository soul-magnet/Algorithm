package Ladder7.FollowUp;

import java.util.ArrayList;

/**
 * 403. Continuous Subarray Sum II - Medium - Required

Given an circular integer array (the next element of the last element is the first element), 
find a continuous subarray in it, where the sum of numbers is the biggest. 
Your code should return the index of the first number and the index of the last number.

If duplicate answers exist, return any of them.

Example
Give [3, 1, -100, -3, 4], return [4,1].

Tags:Subarray Array

Related Problems 
Medium Continuous Subarray Sum 25 %
 * */
public class ContinuousSubarraySum2 {
	
	/**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		int len = A.length;
		int l = 0, r = 0;
		int sum = 0, total = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// scenario: max sum is squeezed in the middle of array
		for (int i = 0; i < len; ++i) {
			total += A[i];
			if (sum > 0) {
				sum = 0 + A[i];
				l = r = i;
			} else {
				sum += A[i];
				r = i;
			}
			if(l==0&&r==len-1)continue;
			if (sum < min) {
			    min=sum;
				result.set(0, (r + 1) % len);
				result.set(1, (l - 1 + len) % len);
			}

		}
		// scenario: max sum is intercepted by min sum in the middle of the
		// array,
		l = 0;
		r = 0;
		sum=0;
		for (int i = 0; i < len; i++) {
			if (sum >= 0) {
				sum += A[i];
				 r = i;
			} else {
				sum =0+ A[i];
				r =l= i;
			}
			if (sum>=max&&total-min< sum) {
				max=sum;
				result.set(0,l);
				result.set(1, r);
			}
			
		}
		return result;
	}

}
