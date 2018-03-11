package main.java.ladders.LinkedList;
/**
 * 64. Merge Sorted Array - Easy - Optional

Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Notice
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.

Example
A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]

Tags 
Array Sorted Array Facebook
Related Problems 
Easy Space Replacement 18 %
Easy Merge Two Sorted Arrays 35 %
 * */
public class MergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] a, int m, int[] b, int n) {
       int i=m-1,j=n-1,s=m+n-1;
        while(i>=0&&j>=0){
            if(a[i]>b[j]){
                a[s--]=a[i--];
            }else{
                a[s--]=b[j--];
            }
        }
        while(i>=0){
            a[s--]=a[i--];
        }
        while(j>=0){
            a[s--]=b[j--];
        }
    }

}
