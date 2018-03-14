package main.java.ladders.Subarray;

import java.util.ArrayList;

/**
 * 402. Continuous Subarray Sum - Medium 

Given an integer array, find a continuous subarray where the sum of numbers is the biggest. 
Your code should return the index of the first number and the index of the last number. 
(If their are duplicate answer, return anyone)

Example
Give [-3, 1, 3, -3, 4], return [1,4].

Tags 
Subarray Array
Related Problems 
Easy Maximum Subarray 38 %
 * */
public class ContinuousSubarraySum {
	/**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(0);
		if(a.length<2)return result;
		int sum = 0, min= 0, max = 0, l= 0;
		for(int i=0; i<a.length; i++){
			sum+=a[i];
			if(min>=sum){
				l=i+1;
				min=sum;
			}
			if(max<=(sum-min)){
				max= sum-min;
				result.set(0, l);
				result.set(1, i);
			}
			
		}
		return result;
	}
}
