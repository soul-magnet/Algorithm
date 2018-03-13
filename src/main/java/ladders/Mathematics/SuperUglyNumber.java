package main.java.ladders.Mathematics;
/**
 * 518. Super Ugly Number - Medium

Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
given primes = [2, 7, 13, 19] of size 4.

 Notice
1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000

Example
Given n = 6, primes = [2, 7, 13, 19] return 13

Tags:Mathematics Heap Google

Related Problems 
Easy Ugly Number 36 %
Medium Ugly Number II 24 %
 * */
public class SuperUglyNumber {
	/**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
                    if (n < 1 || primes == null || primes.length == 0)
                    return 1;

             Arrays.sort(primes);
             Queue<Long> minHeap = new PriorityQueue<Long>(n);
             Set<Long> set = new HashSet<Long>();

             minHeap.add(1L);
             set.add(1L);

             for (int i = 0; i < n; i++) {
                    long crt = minHeap.poll();
                    if (i == n - 1) {
                           return (int)crt;
                    }
                    for (int j : primes) {
                           if ((!set.contains(crt * j))) {
                                 minHeap.add(crt * j);
                                 set.add(crt * j);
                           }
                    }
             }
             return -1;

    }

}
