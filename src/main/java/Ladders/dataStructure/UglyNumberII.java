package DataStructure;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Ugly number is a number that only have factors 3, 5 and 7.
 * Design an algorithm to find the Kth ugly number. 
 * The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
 * Example: If K=4, return 9.
 * Challenge: O(K log K) or O(K) time.
 * Analysis: Priority Queue
 * 
 * Ugly numbers are numbers whose only prime factors are 2, 3, or 5. 
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, ... shows the first 11 ugly 
 * numbers. By convention 1 is included. 
 * */
public class UglyNumberII {
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
