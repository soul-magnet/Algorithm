package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Total runtime in O(nlogn)
 *  Clarification: What's the definition of Median? -Median is the number
 *  that in the middle of a sorted array. If there are n numbers in a sorted 
 *  array A, the median is A[(n -1)/2]. For example; if A = [1,2,3], median is 2.
 *  
 *  A: 
 *  Two heaps. One max-heap store the left half including the median,
 *  the other min-heap stored right half. Thus the size of max-heap can mostly
 *  be one more than the min-heap(iff the size of the array is odd).
 *  
 *  Keep maintaining the size difference by moving elements from one heap to other.
 *  
 *  
 * */
public class DataStreamMedian {
	/**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
	
	public int[] medianII(int[] nums) {
		if (nums == null) return null;
		int[] res = new int[nums.length];
		
		// left half of the median are stored in the maxHeap.
		// median == maxHeap.peek()
		// right half of the median are stored in the minHeap
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // default min heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11 /*default capacity*/, new Comparator<Integer>() {  
            @Override  
            public int compare(Integer x, Integer y) {  
                return y-x;  
            }  
        });
		res[0] = nums[0];
		maxHeap.add(nums[0]);
		
		for (int i = 1; i < nums.length; i++){
			int x = maxHeap.peek();
			if (nums[i] <= x){
				maxHeap.add(nums[i]);
			} else {
				minHeap.add(nums[i]);
			}
			//maxHeap.size() == minHeap.size() || maxHeap.size() == minHeap.size() + 1;
			if(maxHeap.size() > minHeap.size()+1) {
				minHeap.add(minHeap.poll());
			}
			res[i] = maxHeap.peek();
		}
		return res;
	}
}
