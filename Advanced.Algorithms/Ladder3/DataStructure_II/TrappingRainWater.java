package Ladder3.DataStructure_II;
/**
 * 
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
Medium Container With Most Water 40 %
 * */
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

//Juizhang Solution
//Version 0: Two pointer
//public class Solution {
//  /**
//   * @param heights: an array of integers
//   * @return: a integer
//   */
//  public int trapRainWater(int[] heights) {
//      // write your code here
//      int left = 0, right = heights.length - 1; 
//      int res = 0;
//      if(left >= right)
//          return res;
//      int leftheight = heights[left];
//      int rightheight = heights[right];
//      while(left < right) {
//          if(leftheight < rightheight) {
//              left ++;
//              if(leftheight > heights[left]) {
//                  res += (leftheight - heights[left]);
//              } else {
//                  leftheight = heights[left];
//              }
//          } else {
//              right --;
//              if(rightheight > heights[right]) {
//                  res += (rightheight - heights[right]);
//              } else {
//                  rightheight = heights[right];
//              }
//          }
//      }
//      return res;
//  }
//}      

//Version 1
//public class Solution {
//  /**
//   * @param heights: an array of integers
//   * @return: a integer
//   */
//  public int trapRainWater(int[] heights) {
//      if (heights.length == 0) {
//          return 0;
//      }
//      
//      int[] maxHeights = new int[heights.length + 1];
//      maxHeights[0] = 0;
//      for (int i = 0; i < heights.length; i++) {
//          maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
//      }
//      
//      int max = 0, area = 0;
//      for (int i = heights.length - 1; i >= 0; i--) {
//          area += Math.min(max, maxHeights[i]) > heights[i]
//                  ? Math.min(max, maxHeights[i]) - heights[i]
//                  : 0;
//          max = Math.max(max, heights[i]);
//      }
//      
//      return area;
//  }
//}

