package main.java.ladders.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 486. Merge k Sorted Arrays - Medium - Optional

Given k sorted integer arrays, merge them into one sorted array.

Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Challenge 
Do it in O(N log k).

N is the total number of integers.
k is the number of arrays.
Tags 
Heap Priority Queue
Related Problems 
Medium Merge k Sorted Lists 29 %
 * */

class Element {
    public int row, col, val;
    public Element( int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class MergeKSortedArray {

private Comparator<Element> elecomparator = new Comparator <Element>() {
   public int compare (Element l, Element r){
       return l.val- r.val;
   }
};
/**
* @param arrays k sorted integer arrays
* @return a sorted array
*/
public List<Integer> mergekSortedArrays(int[][] arrays) {
// Write your code here
if(arrays == null){
    return new ArrayList<Integer>(0);
}
//result array length
int size = 0;
Queue <Element> hp = new PriorityQueue<Element>(arrays.length, elecomparator);
for (int i=0;i < arrays.length; i++){
    if (arrays[i].length>0){
        Element ele = new Element(i, 0, arrays[i][0]);
        hp.add(ele);
        size +=arrays[i].length;
    }
}
//int[] res = new int [size];
//use to track the index of the res
//int index = 0;
List res = new ArrayList<Integer>(size);
while (!hp.isEmpty()){
    Element ele = hp.poll();
    res.add(ele.val);
    if (ele.col +1<arrays[ele.row].length){
        ele.col +=1;
        ele.val = arrays[ele.row][ele.col];
        hp.add(ele);
    }
}
return res;
}
}
