package Ladder3.DataStructure_II;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 81. Data Stream Median - Hard - Required

Numbers keep coming, return the median of numbers at every time a new number added.

Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array.
If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Challenge 
Total run time in O(nlogn).

Tags: LintCode Copyright Heap Priority Queue Google

Related Problems 
Medium First Unique Number In Stream 21 %
Hard Sliding Window Median 18 %
Easy Sliding Window Average from Data Stream 31 %
Easy Median 24 %
Hard Median of two Sorted Arrays 25 %
 * */
public class DataStreamMedian {
	private int numOfElements = 0;	private PriorityQueue<Integer> max, min;

	public int[] medianII(int[] nums) {
		int cnt = nums.length;
		max = new PriorityQueue<>(cnt, Collections.reverseOrder());
		min = new PriorityQueue<>(cnt);
		int[] ans = new int[cnt];
		for (int i = 0; i < cnt; ++i) {
			addNumber(nums[i]);
			ans[i] = getMedian();
		}
		return ans;
	}

	void addNumber(int value) {
		// use the left top to store
		// star to add it to left, then if max left > min right then switch
		max.add(value);
		// if both side is not even, left +1 = right, then left top is median so
		// compare left and right top, if left is greater than right then swap
		// left and right,
		// if number is even than left- right =2 then left remove to be added to
		// right
		if (numOfElements % 2 == 0) {// if crt is odd (previous even) then check top of l and r
			 if (min.isEmpty()) {
				numOfElements++;
				return;
			} else if (max.peek() > min.peek()) {
				Integer maxRoot = max.poll();
				Integer minRoot = min.poll();
				max.add(minRoot);
				min.add(maxRoot);
			}
		} else {
			min.add(max.poll());
		}
		numOfElements++;
	}

	int getMedian() {
		return max.peek();
	}
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII2(int[] nums) {
        int len = nums.length;
		PriorityQueue<Integer> r = new PriorityQueue<>(len);
		PriorityQueue<Integer> l = new PriorityQueue<>(len, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		int [] res = new int[len];
		res[0]=  nums[0];
		// l
		for (int i =1; i<len; i++){
			if(nums[i]<res[i-1]){
				l.add(nums[i]);
			}else{
				r.add(nums[i]);
			}
			if (l.size()< r.size()){
				if(r.size()- l.size()==1){
					res[i]= res [i-1];
					continue;
				}else{//0 1 2 -> 1 1 1
					l.add(res[i-1]);
					res[i]= r.poll();
				}
			}else if(l.size()==r.size()){
				res[i] = res[i-1];
			}
			else{ //1 1 0-> 0 1 1
				r.add(res[i-1]);
				res[i] = l.poll();
			}
		}
		return res;
    }

}

//Juizhang Solution
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;

    public int[] medianII(int[] nums) {
        // write your code here
        Comparator<Integer> revCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return right.compareTo(left);
            }
        };
        int cnt = nums.length;
        maxHeap = new PriorityQueue<Integer>(cnt, revCmp);
        minHeap = new PriorityQueue<Integer>(cnt);
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }
    void addNumber(int value) {
        maxHeap.add(value);
        if (numOfElements%2 == 0) {
            if (minHeap.isEmpty()) {
                numOfElements++;
                return;
            }
            else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        }
        else {
            minHeap.add(maxHeap.poll());
        }
        numOfElements++;
    }
    int getMedian() {
        return maxHeap.peek();
    }
}
