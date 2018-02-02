package DataStructure;

/*
 * Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Have you met this question in a real interview? Yes
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Challenge
O(n) time complexity

Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.
*/

/*
 * Similarly to the min-heap; to find max-heap;
 * we gotta build 
 * Max-Heap(A[]){
 * 	heapSize[A] = length(A);
 * 	for (i = [length(A)/2]; i >= 1; i--){
 * 		MaxHeapify(A, i);
 * }
 * }
 * 
 * Running Time: Simple Upper Bound Max-Heapify costs O(log n) time
 * property#1
 * There are O(n) such calls => O(nlog n); however we may produce a tighter bound
 * depends upon height of the node O(h)
 * property#2
 * At most [n/2^h+1] nodes are at any height h.
 * */

public class Heapify {
	/**
     * @param A: Given an integer array
     * @return: void
     * for bubbleDown method, int @param k is the index of the array
     */
	private void bubbleDown(int [] A, int k){
		while (k < A.length) {
			int smallest = k;
			if(k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
				smallest = 2 * k + 1;
			}	
			if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
				smallest = 2 * k + 2;
			}
			if (smallest == k){
				break;
			}
			// swap the indexes
			int temp = A[smallest];
			A[smallest] = A[k];
			A[k] = temp;
			
			k = smallest;
		}
	}
	
	public void heapify(int[] A){
		for (int i = A.length / 2; i >= 0; i--){
			bubbleDown(A, i);
		}
	}
}
