package main.java.ladders.Array;

import java.util.Arrays;
import java.util.Comparator;

import main.java.ladders.util.Interval;

/**
 * 252. Meeting Rooms - LeetCode
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * */

/*Ideas: This is similar to the Merge Intervals. So Idea is still the same. 
 * First Sort the intervals according to the start times, then check if there is any overlap.
*/
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		 if(intervals == null || intervals.length == 0) return true;
		 Arrays.sort(intervals, new Comparator<Interval>(){
			 public int compare(Interval i1, Interval i2) {
				 return i1.start - i2.start;
			 }
		 });
		 int end = intervals[0].end;
		 for(int i = 1; i < intervals.length; i++) {
			 if(intervals[i].start < end) return false; //  if(intervals[i].end>intervals[i+1].start); return false;
			 end = Math.max(end, intervals[i].end);
		 }
		 
		 return true;
	 }
	
	//Another version
	 public boolean canAttendMeetings1(Interval[] intervals) {
		 if(intervals == null || intervals.length == 0) return true;
		 
		 //sort according to the start time
		 Arrays.sort(intervals, new IntervalComparator());
		 Interval prev = intervals[0];
		 for(int i = 1; i < intervals.length; i++) {
			 Interval curr = intervals[i];
			 if(isOverlapped(prev, curr)) return false;
			 prev = curr;
		 }
		 return true;
	 }
	 
	public class IntervalComparator implements Comparator<Interval>{
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
	}
	 
	 private boolean isOverlapped(Interval a, Interval b) {
		 return a.end > b.start;
	 }

}

