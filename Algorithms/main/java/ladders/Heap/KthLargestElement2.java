package main.java.ladders.Heap;
/**
 * 606. Kth Largest Element II - Medium

Find K-th largest element in an array. and N is much larger than k.

 Notice
You can swap elements in the array

Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

Tags 
Heap
Related Problems 
Medium Kth Largest Element 26 %
 * */
public class KthLargestElement2 {
	/*
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
       PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

}
