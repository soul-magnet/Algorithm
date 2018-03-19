package main.java.ladders.Stack;

import java.util.Stack;

/**
 * 122. Largest Rectangle in Histogram - Hard -Optional

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example
Given height = [2,1,5,6,2,3],
return 10.

Tags: Stack Array
Related Problems 
Hard Maximal Rectangle 26 %
Hard Max Tree 33 %
 * */
public class LargestRectangleInHistogram {
	 /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
		if(height==null ||height.length==0){
			return 0;
		}
		Stack<Integer> st = new Stack<>();
		int max =0,len=height.length;
		for(int i=0; i<len;i++){
			int current = height[i];
			while(!st.isEmpty() && current<=height[st.peek()]){
				int index = st.pop();
				int  h = height[index];
				int w;
				if(st.isEmpty()){
					w = i+1-1;//the num of ele of current ele  - 1 current node
				}
				else{
					w = i-st.peek()-1;
				}
				max=Math.max(max, w*h);
			}
			st.push(i);
		}
		while(!st.isEmpty() ){
			int index = st.pop();
			int  h = height[index];
			int w;
			if(st.isEmpty()){
				w = len;
			}
			else{
				w = len-1-st.peek();
			}
			max=Math.max(max, w*h);
		}
		return max;
	}
}

//Juizhang Solution
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}
