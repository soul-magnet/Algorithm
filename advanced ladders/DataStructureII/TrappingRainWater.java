package DataStructureII;
/**
 * 363. Trapping Rain Water - Medium - Required

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Trapping Rain Water

Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge 
O(n) time and O(1) memory

O(n) time and O(n) memory is also acceptable.

Tags: Array Two Pointers Forward-Backward Traversal

Related Problems 
Hard Trapping Rain Water II 26 %
Medium Container With Most Water 40 %*/

public class TrappingRainWater {
	 /**
     * @param heights: an array of integers
     * @return: a integer
     * ä¸¤čžš
     */
    	public int trapRainWater(int[] heights) {
		if(heights==null||heights.length<3){
			return 0;
		}
		int l=0, r=heights.length-1,res=0, rh=heights[r], lh=heights[l];
		while(l<r){
			if(lh<rh){
				l++;
				if(lh<=heights[l]){
					lh = heights[l];
				}else{
					res+= lh - heights[l];
				}
			}else{
				r--;
				if(rh<=heights[r]){
					rh= heights[r];
				}else{
					res+= rh-heights[r];
				}
			}
		}
		return res;
	}

}
