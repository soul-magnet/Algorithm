package Ladder1.FollowupCodingInt;

import java.util.HashSet;
import java.util.PriorityQueue;

/** 461. Kth Smallest Numbers in Unsorted Array - Medium - Optional
 * Given two integer arrays sorted in ascending order and an integer k. 
 * Define sum = a + b, where a is an element from the first array and 
 * b is an element from the second one. Find the kth smallest sum out of all possible sums.


Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.

Challenge: Do it in either of the following time complexity:

O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
O( (m + n) log maxValue). where maxValue is the max number in A and B.

Tags: Heap Priority Queue Sorted Matrix

Related Problems 
1 - Medium Kth Smallest Number in Sorted Matrix 24 %
2 - Medium Search a 2D Matrix II
 * */

public class KthSmallestSumInTwoSortedArrays {
    class Pair implements Comparable<Pair>{
       public int index1, index2, sum;
       public Pair(int index1,int  index2,int  sum){
           this.index1=index1;
           this.index2=index2;
           this.sum=sum;
       }

       @Override
       public boolean equals(Object obj) {
           if (obj == this) {
               return true;
           } else if (!(obj instanceof Pair)) {
               return false;
           }
           Pair another = (Pair) obj;
           return this.index1 == another.index1 && this.index2 == another.index2;
       }
       @Override
       public int hashCode() {
           return index1 * 101 + index2;
       }
       @Override
       public int compareTo(Pair o) {

           return this.sum-o.sum;
       }
   }
//    class  cmp implements Comparator<Pair>{
//       @Override
//      public int compare(Pair a, Pair b){
//           return a.sum-b.sum;
//       }
//   }
   /**
    * @param A an integer arrays sorted in ascending order
    * @param B an integer arrays sorted in ascending order
    * @param k an integer
    * @return an integer
    */

   public int kthSmallestSum(int[] A, int[] B, int k) {
       int[] dx = new int[]{0, 1};
       int[] dy = new int[]{1, 0};
       HashSet<Pair> visited = new HashSet<>();
       PriorityQueue<Pair> minHeap = new PriorityQueue<>(k);
       minHeap.add(new Pair(0, 0, A[0] + B[0]));

       for(int i = 0; i < k; i ++){
           Pair cur = minHeap.poll();
          // System.out.println(cur.sum+" "+cur.index1+" "+cur.index2 );
           if(i==k-1){
               return cur.sum;
           }
           for(int j = 0; j < 2; j ++){
               int next_x = cur.index1 + dx[j];
               int next_y = cur.index2 + dy[j];

               if(next_x < A.length && next_y < B.length  ){
                   int sum = A[next_x] + B[next_y];
                   Pair next_Pair = new Pair(next_x, next_y, sum);
                   if( !visited.contains(next_Pair)){
                       minHeap.add(next_Pair);
                       visited.add(next_Pair);
                   }
               }
           }
       }
       return minHeap.peek().sum;
   }
   
   //Juizhang Solution
   /*
    * @param k an integer
    * @param nums an integer array
    * @return kth smallest element
    */
   public int kthSmallest(int k, int[] nums) {
       // write your code here
       return quickSelect(nums, 0, nums.length - 1, k - 1);
   }

   public int quickSelect(int[] A, int start, int end , int k) {

       if (start == end)
           return A[start];
       
       int left = start, right = end;
       int pivot = A[(start + end) / 2];

       while (left <= right) {
           while (left <= right && A[left] < pivot) {
               left++;
           }

           while (left <= right && A[right] > pivot) {
               right--;
           }
           if (left <= right) {
               int temp = A[left];
               A[left] = A[right];
               A[right] = temp;
               
               left++;
               right--;
           }
       }

       if (right >= k && start <= right)
           return quickSelect(A, start, right, k);
       else if (left <= k && left <= end)
           return quickSelect(A, left, end, k);
       else
           return A[k];
   }
}