package Sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Find K-th largest element in an array.
 * Example: In array [9,3,2,4,8], the 3rd largest element is 4.
 * 			In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 * Note: You can swap elements in the array
 * Challenge: O(n) time, O(1) extra memory.
 * 
 * */
public class KthLargestElement {
	//param k : description of k
    //param numbers : array of numbers
    //return: description of return
	
	/*Heap Sort O(nlgk)*/
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        PriorityQueue<Integer>queue = new PriorityQueue<Integer>(k);
        for (int num : numbers){
        	if (queue.size() < k){
        		queue.add(num);
        	} else if (queue.peek() < num){
        		queue.remove();
        		queue.add(num);
        	}
        }
        return queue.peek();
    }
    
    /*Quick Select: */
    public int findKthLargest(int[] nums, int k) {
        return findPos(nums, 0, nums.length - 1, k);
    }
    private int findPos(int[] nums, int start, int end, int order) {
        int pivot = nums[start];
        int smaller = start;
        int greater = end + 1;
        int index = start + 1;
        while (index < greater) {
            if (nums[index] <= pivot) {
                smaller++;
                index++;
            } else {
                int tmp = nums[--greater];
                nums[greater] = nums[index];
                nums[index] = tmp;
            }
        }
        index--;
        nums[start] = nums[index];
        nums[index] = pivot;
        if (end - index == order - 1) {
            return pivot;
        } else if (end - index < order - 1) {
            return findPos(nums, start, index - 1, order - (end - index) - 1);
        } else {
            return findPos(nums, index + 1, end, order);
        }
    }
};
