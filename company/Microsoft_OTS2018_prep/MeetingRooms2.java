package Microsoft_OTS2018_prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import main.java.ladders.util.Interval;

/**
 * 253. Meeting Rooms II - Medium
 * 
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

	For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * */
/*Analysis: Invariant - Overlapping events in the heap
 * The heap stores all overlapping events. When a new event comes, we greedly choose the event X tht finished the
 * earliest. If the nwe event does not overlap with the X, then the new event can re-use X's room, or simply extend
 * X's event to the new event's end time.
 * 
 * If the new event overlaps with X, then it must overlaps with all other events in the heap. 
 * So a new room must be created.
 * 
 * The reason for correctness is the invariant: heap size is always the minimum number of rooms we need so far.
 * 
 * Time Complexity: O(nlgn): sort according to the start time takes NlgN time 
 *                  and then we might push and pop from the heap that takes lgN time
 *                  we have n entries, tahat also takes lgN time
 * Space Complexity: O(n)
 * */
public class MeetingRooms2 {
	
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
		
		//sort the object based on start and use priorityQueue to manage the min values
		Arrays.sort(intervals, new IntervalComparator());
		PriorityQueue<Integer> pq = new PriorityQueue();
		pq.add(intervals[0].end);
		
		for(int i = 1; i< intervals.length; i++) {
			Interval curr = intervals[i];
			if(curr.start >= pq.peek()) pq.remove();
			pq.add(curr.end);
		}
		return pq.size();
	}
	
	private class IntervalComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

}
