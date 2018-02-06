package Ladder4.BinarySearch_SweepLine;

import java.util.ArrayList;
import java.util.List;

/**
 * 390. Find Peak Element II - Hard - Required
 
There is an integer matrix which has the following features:

The numbers in adjacent positions are different.
The matrix has n rows and m columns.
For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
We define a position P is a peek if:

A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
Find a peak element in this matrix. Return the index of the peak.

 Notice
The matrix may contains multiple peeks, find any of them.

Example
Given a matrix:

[
  [1 ,2 ,3 ,6 ,5],
  [16,41,23,22,6],
  [15,17,24,21,7],
  [14,18,19,20,10],
  [13,14,11,10,9]
]
return index of 41 (which is [1,1]) or index of 24 (which is [2,2])

Challenge 
Solve it in O(n+m) time.

If you come up with an algorithm that you thought it is O(n log m) or O(m log n), 
can you prove it is actually O(n+m) or propose a similar but O(n+m) algorithm?

Tags 
LintCode Copyright Binary Search Matrix
Related Problems 
Medium Find Peak Element 48 %
 * */
public class FindPeakElement2 {
	/**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
     public List<Integer> findPeakII(int[][] a) {
        List<Integer> res = new ArrayList<Integer>();
        int l = 1, r = a.length-2;
        while(l + 1 <r){
            int mid = l+(r-l) / 2;
            int col = find(mid, a);// find the peak ele of the mid th row
            
            if(a[mid][col]<a[mid-1][col]){
                r= mid;
            }else if (a[mid][col]<a[mid+1][col]){
                l= mid;
            }else {
                res.add(mid);
                res.add(col);
                return res;
            }
        }
        int coll = find(l, a);
        int colr= find(r, a);
        if(a[l][coll]<a[l+1][coll]){
            res.add(r);
            res.add(colr);
            return res;
        }
        res.add(l);
        res.add(coll);
        return res;
    }
    private int find(int row, int [][]a) { 
        int l=0, r= a[row].length-1;
        while(l+1<r){
            int mid = l+ (r-l)/2;
            if(a[row][mid]< a[row][mid+1]){
                l=mid;
            }else if(a[row][mid]< a[row][mid-1]){
                r=mid;
            }else{
                r=mid;
            }
        }
        if(a[row][l]< a[row][r]){
            return r;
        }else{
            return l;
        }
        
    } 

}

//Jiuzhang Solution
//O(n + m) 解法
class Solution {
 /**
  * @param A: An integer matrix
  * @return: The index of the peak
  */
 public List<Integer> find(int x1, int x2, int y1, int y2,
                           int[][] A) {
     
     int mid1 = x1 + (x2 - x1) / 2;
     int mid2 = y1 + (y2 - y1) / 2;
     
     int x = mid1, y = mid2;
     int max = A[mid1][mid2];
     for (int i = y1; i <= y2; ++i)
         if (A[mid1][i] > max) {
             max = A[mid1][i];
             x = mid1;
             y = i;
         }

     for (int i = x1; i <= x2; ++i)
         if (A[i][mid2] > max) {
             max = A[i][mid2];
             x = i;
             y = mid2;
         }
     
     boolean isPeak = true;
     if (A[x - 1][y] > A[x][y]) {
         isPeak = false;
         x -= 1;
     } else if (A[x + 1][y] > A[x][y]) {
         isPeak = false;
         x += 1;
     } else if (A[x][y - 1] > A[x][y]) {
         isPeak = false;
         y -= 1;
     } else if (A[x][y + 1] > A[x][y]) {
         isPeak = false;
         y += 1;
     }
        
     if (isPeak) {
         return new ArrayList<Integer>(Arrays.asList(x, y));
     }
     
     if (x >= x1 && x < mid1 && y >= y1 && y < mid2) {
         return find(x1, mid1 - 1, y1, mid2 - 1, A);
     }
     
     if (x >= 1 && x < mid1 && y > mid2 && y <= y2) {
         return find(x1, mid1 - 1, mid2 + 1, y2, A);
     }
     
     if (x > mid1 && x <= x2 && y >= y1 && y < mid2) {
         return find(mid1 + 1, x2, y1, mid2 - 1, A);
     }
     
     if (x >= mid1 && x <= x2 && y > mid2 && y <= y2) {
         return find(mid1 + 1, x2, mid2 + 1, y2, A);
     }
     
     return new ArrayList<Integer>(Arrays.asList(-1, -1));
     
 }
 public List<Integer> findPeakII(int[][] A) {
     // write your code here
     int n = A.length;
     int m = A[0].length;
     return find(1, n - 2, 1, m - 2, A);
 }
}


class Solution {
 /**
  * @param A: An integer matrix
  * @return: The index of the peak
  */
 public List<Integer> findPeakII(int[][] A) {
     // this is the nlog(n) method
     int low = 1, high = A.length-2;
     List<Integer> ans = new ArrayList<Integer>();
     while(low <= high) {
         int mid = (low + high) / 2;
         int col = find(mid, A);
         if(A[mid][col] < A[mid - 1][col]) {
             high = mid - 1;
         } else if(A[mid][col] < A[mid + 1][col]) {
             low = mid + 1;
         } else {
             ans.add(mid);
             ans.add(col);
             break;
         }
     }
     return ans;
 }
 int find(int row, int [][]A) {
     int col = 0;
     for(int i = 0; i < A[row].length; i++) {
         if(A[row][i] > A[row][col]) {
             col = i;
         }
     }
     return col;
 } 
}
