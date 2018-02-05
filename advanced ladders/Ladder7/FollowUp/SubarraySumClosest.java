package Ladder7.FollowUp;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 139. Subarray Sum Closest - Medium - Required
 
Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

Challenge 
O(nlogn) time

Tags:Sort Subarray

Related Problems 
Medium Submatrix Sum 26 %
Hard Subarray Sum II 31 %
Medium Minimum Size Subarray Sum 27 %
Easy Subarray Sum 31 %
 * */
public class SubarraySumClosest {
	
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     
     public int[] subarraySumClosest(int[] x) {
        TreeSet<Element> treeSet = new TreeSet<>();
        int prefix = 0;
        treeSet.add(new Element(0, -1));
        int minDiff = Integer.MAX_VALUE;
        int res [] = new int[2];
        for (int i =0; i< x.length; i++){
            prefix += x[i];
            if(treeSet.first().val<= prefix){
                Element low  = treeSet.floor(new Element(prefix, -2));
                int sum = prefix -low.val;
                if(Math.abs(minDiff)>=Math.abs(sum-prefix)){
                    minDiff = prefix -sum;
                    res[1]= i;
                    res[0]= low.index+1;
                }
            }
            if(treeSet.last().val>= prefix){
                Element high  = treeSet.ceiling(new Element(prefix, -2));
                int sum = prefix -high.val;
                if(Math.abs(minDiff)>=Math.abs(sum-prefix)){
                    minDiff = prefix -sum;
                    res[1]= i;
                    res[0]= high.index+1;
                }
            }
            treeSet.add(new Element(prefix, i));
        }
        return res;

    }
    
    public int[] subarraySumClosest1(int[] a) {
        // write your code here
        //close to 0: 1 find all 0-i sum with index, 2 sort it, 3 find min difference between ajacent two
        int res[] = new int[2];
	    	if(a.length==0||a==null||a.length==1){
	    		return res;
	    	}
	    	int sum= 0;
	    	Element element[] = new Element[a.length];
	    	for (int i=0; i < a.length; i++){
	    		sum += a[i];
	    		element[i]=new Element(sum, i);
	    	}
	    	Arrays.sort(element);
	    	int min= Math.abs(element[0].getValue()-element[1].getValue());
	    	int index1 = Math.min(element[0].getIndex(),element[1].getIndex())+1;
	    	int index2 = Math.max(element[0].getIndex(),element[1].getIndex());
	    	for (int i=1; i < element.length-1; i++){
	    		if(Math.abs(element[i].getValue()-element[i+1].getValue())<= min){
	    		min=Math.abs(element[i].getValue()-element[i+1].getValue());
	    		index1 = Math.min(element[i].getIndex(),element[i+1].getIndex())+1;
		    	index2 = Math.max(element[i].getIndex(),element[i+1].getIndex());
	    		}
	    	}
	    	res[0]= index1;
	    	res[1]= index2;
	    	return res;
    }
    
    class Element implements Comparable<Element>{
	    int val;
	    int index;
	    public Element(int v, int i){
	        val = v;
	        index = i;
	    }

	    public int compareTo(Element other){
	        return this.val-other.val ;
	    }

	    public int getIndex(){
	        return index;
	    }

	    public int getValue(){
	        return val;
	    }
	}

}
