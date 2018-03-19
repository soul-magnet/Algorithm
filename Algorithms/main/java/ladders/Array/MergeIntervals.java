package main.java.ladders.Array;
/**
 * 156. Merge Intervals - Easy

Given a collection of intervals, merge all overlapping intervals.
 
Example
Given intervals => merged intervals:

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]

Challenge: O(n log n) time and O(1) extra space.

Tags: Array Sort LinkedIn Google

Related Problems 
Medium Number of Airplanes in the Sky 27 %
Easy Insert Interval 23 %
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import main.java.ladders.util.Interval;

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class MergeIntervals {
	/**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
	  //Idea is that for the result distinct Interval, the latter one's start must > previoud one's end
    public List<Interval>merge1(List<Interval>intervals){
    	//sort start&end
    	int n = intervals.size();
    	int[] starts = new int[n];
    	int[] ends = new int[n];
    	for(int i = 0; i < n; i++) {
    		starts[i] = intervals.get(i).start;
    		ends[i] = intervals.get(i).end;
    	}
    	
    	Arrays.sort(starts);
    	Arrays.sort(ends);
    	//loop through
    	List<Interval>result = new ArrayList<Interval>();
    	for(int i = 0, j = 0; i< n; i++) { // j is start of interval
    		if(i == n-1 || starts[i+1] > ends[i]) {
    			result.add(new Interval(starts[j], ends[i]));
    			j = i + 1;
    		}
    	}
    	return result;
    }
    
  //Another Version - Using Java8 Lambda expression
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals == null || intervals.size() <= 1) return intervals;
    	
    	//sort by ascending starting point using an anonymous Comparator
    	 intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    	 
    	 List<Interval>result = new ArrayList<>();
    	 int start = intervals.get(0).start;
    	 int end = intervals.get(0).end;
    	 
    	 for(Interval interval : intervals) {
    		 if(interval.start <= end) { //Overlapping intervals, move the end if needed
    			 end = Math.max(end, interval.end);
    		 }else { //disjoint intervals, add the previous one and reset bounds
    			 result.add(new Interval(start, end));
    			 start = interval.start;
    			 end = interval.end;
    		 }
    	 }
    	 //Add the last interval
    	 result.add(new Interval(start, end));
    	 return result;
    }
    
    //Using Stacks - consize
    public List<Interval>merge2(List<Interval>intervals){
    	Stack<Interval>stack = new Stack();
    	Collections.sort(intervals, (a, b) -> a.start - b.start);
    	for(Interval it : intervals) {
    		if(stack.isEmpty() || it.start > stack.peek().end)stack.push(it);
    		else {
    			stack.peek().end = Math.max(it.end, stack.peek().end);
    		}
    	}
    	
    	return new ArrayList(stack);
    }

}
