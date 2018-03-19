package main.java.ladders.LinkedList;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 547. Intersection of Two Arrays - Easy - Optional

Given two arrays, write a function to compute their intersection.

 Notice
Each element in the result must be unique.
The result can be in any order.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Challenge 
Can you implement it in three different algorithms?

Tags: Hash Table Binary Search Two Pointers Sort

Related Problems 
Easy Intersection of Two Arrays II 23 %
Medium Count of Smaller Number 21 %
Easy Merge Two Sorted Arrays 35 %
 * */
public class IntersectionOfTwoArrays {
	/**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        	Arrays.sort(nums1);
		Arrays.sort(nums2);
		// 2 pointer, temp [] for intersection, res[ct]: copy temp to res
		int i=0, j=0, ct =0 ; int [] temp= new int [nums1.length];
		while(i<nums1.length&&j<nums2.length){
			if(nums1[i]== nums2[j]){
				if(ct==0||temp[ct-1]<nums1[i]){
					temp[ct++]= nums1[i];
				}				
				i++;
				j++;
			}else if(nums1[i]<nums2[j]){
				i++;
			}else if (nums1[i]>nums2[j]){
				j++;
			}
		}
		int []res = new int [ct];
		for (int i1=0; i1<ct;i1++){
			res[i1]=temp[i1];
		}
		return res;
    }
    
    // hash set
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> nums = new HashSet<Integer>();
		// nums.addAll(new ArrayList(Arrays.asList(nums1)));
		for (int i : nums1) {
			nums.add(i);
		}
		HashSet<Integer> res = new HashSet<Integer>();
		// nums map the intersection, res stores resul
		// imp: once adding ele, check intersecion and res has already stored
		// the ele
		for (int i = 0; i < nums2.length; i++) {
			if (nums.contains(nums2[i]) && !res.contains(nums2[i])) {
				res.add(nums2[i]);
			}
		}
		int k = 0;
		int[] ans = new int[res.size()];
		for (Integer j : res) {
			ans[k++] = j;
		}
		return ans;
	}

}
