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
