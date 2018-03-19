package main.java.ladders.dataStructure;

import java.util.PriorityQueue;
import java.util.Queue;
/** 4. Ugly Number II - Medium

Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. 
The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

 Notice
Note that 1 is typically treated as an ugly number.

Example
If n=9, return 10.

Challenge 
O(n log n) or O(n) time.

Tags: LintCode Copyright Priority Queue

Related Problems 
Medium Merge Number 35 %
Medium Super Ugly Number 28 %
Medium Perfect Squares 32 %
Easy Happy Number 32 %
Medium Merge k Sorted Lists 29 %
 * */


/* Analysis: Priority Queue
 * 
 * Ugly numbers are numbers whose only prime factors are 2, 3, or 5. 
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, ... shows the first 11 ugly 
 * numbers. By convention 1 is included. 
 * */
public class UglyNumber2 {
	/**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        long uglyNumber = 0;
        Queue pq = new PriorityQueue<Long>();
        pq.offer((long)3);
        pq.offer((long)5);
        pq.offer((long)7);
        
        for (int i = 0; i < k; i++){
        	uglyNumber = (long)pq.poll();
        	if (uglyNumber % 3 == 0){
        		pq.offer(uglyNumber * 3);
        		pq.offer(uglyNumber * 5);
        	} else if(uglyNumber % 5 == 0){
        		pq.offer(uglyNumber * 3);
        		pq.offer(uglyNumber * 5);
        		pq.offer(uglyNumber * 7);
        	}
        }
        return uglyNumber;
    }
}
