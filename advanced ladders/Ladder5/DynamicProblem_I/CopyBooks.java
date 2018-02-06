package Ladder5.DynamicProblem_I;
/**
 * 437. Copy Books 

Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. 
For example one copier can copy the books from ith to jth continously, 
but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. 
What's the best strategy to assign books so that the slowest copier can finish at earliest time?

Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3.)
 *
 * 
 * */
public class CopyBooks {
	

}
//Juizhang Solution
//version 1: Binary Search
//this version cost O(n log m) where n is the number of books and m is the sum of the pages.
public class Solution {
 /**
  * @param pages: an array of integers
  * @param k: an integer
  * @return: an integer
  */
 public int copyBooks(int[] pages, int k) {
     if (pages.length == 0) {
         return 0;  
     }
     
     int total = 0;
     int max = pages[0];
     for (int i = 0; i < pages.length; i++) {
         total += pages[i];
         if (max < pages[i]) {
             max = pages[i];
         }
     }
     
     int start = max;
     int end = total;
     
     while (start + 1 < end) {
         int mid = (end - start) / 2 + start;
         if (countCopiers(pages, mid) > k) {
             start = mid;
         } else {
             end = mid;
         }
     }
     
     if (countCopiers(pages, start) <= k) {
         return start;
     }
     
     return end;
 }
 
 private int countCopiers(int[] pages, int limit) {
     if (pages.length == 0) {
         return 0;
     }
     
     int copiers = 1;
     int sum = pages[0]; // limit is always >= pages[0]
     for (int i = 1; i < pages.length; i++) {
         if (sum + pages[i] > limit) {
             copiers++;
             sum = 0;
         }
         sum += pages[i];
     }
     
     return copiers;
 }
}

//version 2: Dynamic Programming
public class Solution {
 /**
  * @param pages: an array of integers
  * @param k: an integer
  * @return: an integer
  */
 public int copyBooks(int[] pages, int k) {
     // write your code here
     if(pages == null){
         return 0;
     }
     int n = pages.length;
     if (n == 0){
         return 0;
     }
        
     if (k > n) {
         k = n;
     }
     int[] sum = new int[n];
     sum[0] = pages[0];
     for (int i = 1; i < n; ++i) {
         sum[i] = sum[i-1] + pages[i];
     }
     int[][] f = new int[n][k];
     for (int i=0; i<n; ++i) f[i][0] = sum[i];
     for (int j=1; j<k; ++j) {
         int p = 0;
         f[0][j] = pages[0];
         for (int i = 1; i < j; ++i) f[i][j] = Math.max(f[i-1][j], pages[i]); 
         for (int i = j; i < n; ++i) {
             while (p < i && f[p][j-1] < sum[i] - sum[p]) ++p;
             f[i][j] = Math.max(f[p][j - 1], sum[i] - sum[p]);                
             if (p > 0) {
                 --p;
             }
             f[i][j] = Math.min(f[i][j], Math.max(f[p][j - 1], sum[i] - sum[p]));         
         }
     }
     return f[n - 1][k - 1];
 }
}

//verison 3 动态规划专题班版本
public class Solution {
 /**
  * @param pages: an array of integers
  * @param k: an integer
  * @return: an integer
  */
 public int copyBooks(int[] A, int K) {
     int n = A.length;
     if (n == 0) {
         return 0;
     }
     
     int i, j, k, sum;
     
     int[][] f = new int[2][n + 1];
     int old, now = 0;
     for (i = 0; i <= n; ++i) {
         f[now][i] = Integer.MAX_VALUE;
     }
     
     f[now][0] = 0;
     for (i = 1; i <= K; ++i) {
         old = now;
         now = 1 - now;
         for (j = 0; j <= n; ++j) {
             f[now][j] = Integer.MAX_VALUE;
             sum = 0;
             for (k = j; k >= 0; --k) {
                 if (f[old][k] < Integer.MAX_VALUE) {
                     f[now][j] = Math.min(f[now][j], Math.max(sum, f[old][k]));
                 }
                 
                 if (k > 0) {
                     sum += A[k - 1];
                 }
             }
         }
     }
     
     return f[now][n];
 }
}
