package main.java.ladders.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 548. Intersection of Two Arrays II - Easy - Optional

Given two arrays, write a function to compute their intersection.

 Notice
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Challenge 
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, 
and the memory is limited such that you cannot load all elements into the memory at once?

Tags: Hash Table Binary Search Two Pointers Sort

Related Problems 
Easy Intersection of Two Arrays 24 %
Medium Count of Smaller Number 21 %
Easy Merge Two Sorted Arrays 35 %
 * */
public class IntersectionOfTwoArrays2 {
	 /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
   	public int[] intersection1(int[] nums1, int[] nums2) {
        if(nums1==null||nums2 ==null|| nums1.length==0||nums2.length==0){
            return new int[0] ;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 =0, index2=0;
        while (index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]==nums2[index2]){
                list.add(nums1[index1]);
                index1++;
                index2++;
            }else if(nums1[index1]<nums2[index2]){
                index1++;
            }else{
                index2++;
            }

        }
        int [] res = new int[list.size()];int j=0;
        for(int i: list){
            res[j]=i;
            j++;
        }
        return res;
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2 ==null|| nums1.length==0||nums2.length==0){
            return new int[0] ;
        }
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        for (int i: nums2){
            if(map.containsKey(i)&&map.get(i)>0){
                map.put(i,map.get(i)-1);
                list.add(i);
            }
        }
        
        int [] res = new int[list.size()];int j=0;
        for(int i: list){
            res[j]=i;
            j++;
        }
        return res;
    }

}
