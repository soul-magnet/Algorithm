package main.java.ladders.Heap;
/**
 * 130. Heapify - Medium -

Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and 
A[i * 2 + 2] is the right child of A[i].

Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop and top. where "push" add
a new element the heap, "pop" delete the minimum/maximum element in the heap, 
"top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. 
If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Challenge 
O(n) time complexity

Tags: LintCode Copyright Heap
 * */
public class Heapify {
	
    /**
     * @param A: Given an integer array
     * @return: void
     * analysis: must from the mid to 0, otherwise it will never address a[0] value, do sift down 
     */
     // Version 1: This cost O(n)
     private void siftdown(int[] A, int k) {
         int son = k * 2 + 1;
        while (son < A.length) {
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2])
                son = k * 2 + 2;
            if (A[son] >= A[k])
                break;
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
            son = k * 2 + 1;
        }
    }
    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
    // Version 2: This cost O(nlogn)
    private void siftup(int[] a, int k) {
         int father = (k-1)/2;
         while(father>-1){
             if(a[k]>=a[father]){
                 break;
             }
             //swap
             int temp = a[k];
             a[k] = a[father];
             a[father] =  temp;
             k= father;
             father=(k-1)/2;
         }
    }
    public void heapify1(int[] a) {
        for(int i =0; i< a.length; i++){
            siftup(a,i);
        }
    }

}

//Juizhang Solution
//Version Linpz
public class Solution {
 /**
  * @param A: Given an integer array
  * @return: void
  */
 private void siftdown(int[] A, int k) {
     while (k * 2 + 1 < A.length) {
         int son = k * 2 + 1;
         if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2])
             son = k * 2 + 2;
         if (A[son] >= A[k])
             break;
         
         int temp = A[son];
         A[son] = A[k];
         A[k] = temp;
         k = son;
     }
 }
 
 public void heapify(int[] A) {
     for (int i = (A.length - 1) / 2; i >= 0; i--) {
         siftdown(A, i);
     }
 }
}

//Version 1: this cost O(n)
public class Solution {
 /**
  * @param A: Given an integer array
  * @return: void
  */
 private void siftdown(int[] A, int k) {
     while (k < A.length) {
         int smallest = k;
         if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
             smallest = k * 2 + 1;
         }
         if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
             smallest = k * 2 + 2;
         }
         if (smallest == k) {
             break;
         }
         int temp = A[smallest];
         A[smallest] = A[k];
         A[k] = temp;
         
         k = smallest;
     }
 }
 
 public void heapify(int[] A) {
     for (int i = A.length / 2; i >= 0; i--) {
         siftdown(A, i);
     } // for
 }
}


//Version 2: This cost O(nlogn)
public class Solution {
 /**
  * @param A: Given an integer array
  * @return: void
  */
 private void siftup(int[] A, int k) {
     while (k != 0) {
         int father = (k - 1) / 2;
         if (A[k] > A[father]) {
             break;
         }
         int temp = A[k];
         A[k] = A[father];
         A[father] = temp;
         
         k = father;
     }
 }
 
 public void heapify(int[] A) {
     for (int i = 0; i < A.length; i++) {
         siftup(A, i);
     }
 }
}