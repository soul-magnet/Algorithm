package ladderIFollowupCodingInt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/** Optional
 * Find K-th largest element in N arrays.

 Notice: You can swap elements in the array


Example
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.

In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.

Tags: Heap

Related Problems 
1 - Medium Largest Number
 * 
 * 
 * */

public class KthLargestinNArrays {
    class Node {
        public int row, value, column;
        public Node(int row, int column, int value){
            this.value =value;
            this.row = row;
            this.column = column;
        }
    }
    class Cmp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
         Queue<Node> maxHeap = new PriorityQueue<>(k,new Cmp());
        int ct = 0;
       for(int [] crt: arrays){
           Arrays.sort(crt);
           if(crt.length!=0){
               maxHeap.add(new Node(ct,crt.length-1, crt[crt.length-1]));
           }
           ct++;
       }
        for ( int i=0; i<k; i++ ){
            Node temp = maxHeap.poll();
            if(i==k-1){
                return temp.value;
            }
            if(temp.column>0){
                --temp.column;
                maxHeap.add(new Node(temp.row,temp.column,arrays[temp.row][temp.column]));
            }
            
        }
        return -1;
    }
}
