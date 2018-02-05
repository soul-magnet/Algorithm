package Ladder3.DataStructure_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 360. Sliding Window Median - Hard - Required

Given an array of n integer, and a moving window(size k), 
move the window at each iteration from the start of the array, 
find the median of the element inside the window at each moving. 
(If there are even numbers in the array, 
return the N/2-th number after sorting the element in the window. )

Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;

Challenge 
O(nlog(n)) time

Tags 
LintCode Copyright Heap
Related Problems 
Medium Sliding Window Unique Elements Sum 12 %
Easy Window Sum 33 %
Hard Paint House II 26 %
Super Building Outline 14 %
Super Sliding Window Maximum 27 %
Hard Data Stream Median 30 %
 * */
public class SlidingWindowMedian {
	
	private PriorityQueue<Integer> l, r; //max, min;
	private int len =0;
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	    ArrayList<Integer> res = new ArrayList<>();
		if(nums==null||k==0){
			return res;
		}
		l = new PriorityQueue<>(k, Collections.reverseOrder());
		r = new PriorityQueue<>();
		for(int i=0;i<nums.length; i++){
			if(i<k-1){
				addEle(nums[i],k);
				continue;
			}
			if(i==k-1){
				addEle(nums[i],k);
				res.add(l.peek());
				continue;
			}
			removeEle(nums[i-k], k);
			addEle(nums[i],k);
			res.add(l.peek());
		}
		return res;
	}

	private void removeEle(int i, int k) {
	if(i>l.peek()){
			r.remove(i);
		}else{
			l.remove(i);
		}len--;
		if(len%2==0){
			while(l.size()<len/2){
				l.add(r.poll());
			}
			while(l.size()>len/2){
				r.add(l.poll());
			}
		}else{
			while(l.size()<len/2+1){
				l.add(r.poll());
			}
			while(l.size()>len/2+1){
				r.add(l.poll());
			}
		}
	}

	private void addEle(int i, int k) {
		l.add(i);
			if(len%2==0){//not even
				if( r.isEmpty()){
					len++;
					return;
				}
				if(r.peek()<l.peek()){
					int right = r.poll();
					int left = l.poll();
					r.add(left);
					l.add(right);
				}
			}else{//even
				r.add(l.poll());
			}
		len++;
	}

}

//Juizhang Solution
//TreeMap Version
import java.util.*;


public class Solution {
 /**
	 * @param nums
	 *            : A list of integers.
	 * @return: The median of the element inside the window at each moving.
	 */
	public  ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	    int n = nums.length;
     TreeSet<Node> minheap = new TreeSet<Node>();
     TreeSet<Node> maxheap = new TreeSet<Node>();
     ArrayList<Integer> result = new ArrayList<Integer> ();
     
     if (k == 0)
         return result;
     
     int half = (k+1)/2;
     for(int i=0; i<k-1; i++) {
         add(minheap, maxheap, half, new Node(i, nums[i]));
     }
     for(int i=k-1; i<n; i++) {
         add(minheap, maxheap, half, new Node(i, nums[i]));
         result.add(minheap.last().val);
         remove(minheap,maxheap, new Node(i-k+1, nums[i-k+1]));
     }
     return result;
 }
 
 void add(TreeSet<Node>minheap, TreeSet<Node> maxheap, int size, Node node) {
     if (minheap.size()<size) {
         minheap.add(node);
     }
     else {
         maxheap.add(node);
     }
     if (minheap.size()==size) {
         if (maxheap.size()>0 && minheap.last().val>maxheap.first().val) {
             Node s = minheap.last();
             Node b = maxheap.first();
             minheap.remove(s);
             maxheap.remove(b);
             minheap.add(b);
             maxheap.add(s);
         }
     }
 }
 
 void remove(TreeSet<Node>minheap, TreeSet<Node> maxheap, Node node) {
     if (minheap.contains(node)) {
         minheap.remove(node);
     }
     else {
         maxheap.remove(node);
     }
 }
}

class Node implements Comparable<Node>{
 int id;
 int val;
 Node(int id, int val) {
     this.id = id;
     this.val = val;
 }
 public int compareTo(Node other) {
     Node a =(Node)other;
     if (this.val == a.val) {
         return this.id - a.id;
     }
     return this.val - a.val;
 }
}


//Normal heap Version
public class Solution {
 /**
  * @param nums: A list of integers.
  * @return: The median of the element inside the window at each moving.
  */
 public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
     // write your code here
     ArrayList<Integer> result = new ArrayList<Integer>();
     int size = nums.length;
     if (size == 0 || size < k) {
         return result;
     }

     PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
     PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(11, Collections.reverseOrder());

     int median = nums[0];
     int j = 0;
     if (k == 1) {
         result.add(median);
     }

     for (int i = 1; i < size; i++) {
         if (nums[i] > median) {
             minPQ.offer(nums[i]);
         } else {
             maxPQ.offer(nums[i]);
         }

         if (i > k - 1) {
             if (nums[j] > median) {
                 minPQ.remove(nums[j]);
             } else if (nums[j] < median) {
                 maxPQ.remove(nums[j]);
             } else {
                 median = Integer.MIN_VALUE;
             }
             j++;
         }

         if (median == Integer.MIN_VALUE) {
             median = minPQ.size() > maxPQ.size() ? minPQ.poll() : maxPQ.poll();
         } else {
             while (minPQ.size() >= maxPQ.size() + 2) {
                 maxPQ.offer(median);
                 median = minPQ.poll();
             }
             while (maxPQ.size() >= minPQ.size() + 1) {
                 minPQ.offer(median);
                 median = maxPQ.poll();
             }
         }
         if (i >= k - 1) {
             result.add(median);
         }
     }

     return result;
 }
}

//Hash Heap Version
import java.util.*;

class HashHeap {
 ArrayList<Integer> heap;
 String mode;
 int size_t;
 HashMap<Integer, Node> hash;

 class Node {
     public Integer id;
     public Integer num;

     Node(Node now) {
         id = now.id;
         num = now.num;
     }

     Node(Integer first, Integer second) {
         this.id = first;
         this.num = second;
     }
 }

 public HashHeap(String mod) {
     // TODO Auto-generated constructor stub
     heap = new ArrayList<Integer>();
     mode = mod;
     hash = new HashMap<Integer, Node>();
     size_t = 0;
 }

 int peak() {
     return heap.get(0);
 }

 int size() {
     return size_t;
 }

 Boolean empty() {
     return (heap.size() == 0);
 }

 int parent(int id) {
     if (id == 0) {
         return -1;
     }
     return (id - 1) / 2;
 }

 int lson(int id) {
     return id * 2 + 1;
 }

 int rson(int id) {
     return id * 2 + 2;
 }

 boolean comparesmall(int a, int b) {
     if (a <= b) {
         if (mode == "min")
             return true;
         else
             return false;
     } else {
         if (mode == "min")
             return false;
         else
             return true;
     }

 }

 void swap(int idA, int idB) {
     int valA = heap.get(idA);
     int valB = heap.get(idB);

     int numA = hash.get(valA).num;
     int numB = hash.get(valB).num;
     hash.put(valB, new Node(idA, numB));
     hash.put(valA, new Node(idB, numA));
     heap.set(idA, valB);
     heap.set(idB, valA);
 }

 Integer poll() {
     size_t--;
     Integer now = heap.get(0);
     Node hashnow = hash.get(now);
     if (hashnow.num == 1) {
         swap(0, heap.size() - 1);
         hash.remove(now);
         heap.remove(heap.size() - 1);
         if (heap.size() > 0) {
             siftdown(0);
         }
     } else {
         hash.put(now, new Node(0, hashnow.num - 1));
     }
     return now;
 }

 void add(int now) {
     size_t++;
     if (hash.containsKey(now)) {
         Node hashnow = hash.get(now);
         hash.put(now, new Node(hashnow.id, hashnow.num + 1));

     } else {
         heap.add(now);
         hash.put(now, new Node(heap.size() - 1, 1));
     }

     siftup(heap.size() - 1);
 }

 void delete(int now) {
     size_t--;
     ;
     Node hashnow = hash.get(now);
     int id = hashnow.id;
     int num = hashnow.num; 
     if (hashnow.num == 1) {

         swap(id, heap.size() - 1);
         hash.remove(now);
         heap.remove(heap.size() - 1);
         if (heap.size() > id) {
             siftup(id);
             siftdown(id);
         }
     } else {
         hash.put(now, new Node(id, num - 1));
     }
 }

 void siftup(int id) {
     while (parent(id) > -1) {
         int parentId = parent(id);
         if (comparesmall(heap.get(parentId), heap.get(id)) == true) {
             break;
         } else {
             swap(id, parentId);
         }
         id = parentId;
     }
 }

 void siftdown(int id) {
     while (lson(id) < heap.size()) {
         int leftId = lson(id);
         int rightId = rson(id);
         int son;
         if (rightId >= heap.size() || (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
             son = leftId;
         } else {
             son = rightId;
         }
         if (comparesmall(heap.get(id), heap.get(son)) == true) {
             break;
         } else {
             swap(id, son);
         }
         id = son;
     }
 }
}

public class Solution {
 /**
  * @param nums
  *            : A list of integers.
  * @return: The median of the element inside the window at each moving.
  */
 public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
     // write your code here

     ArrayList<Integer> ans = new ArrayList<Integer>();
     if (nums.length == 0)
         return ans;
     int median = nums[0];
     HashHeap minheap = new HashHeap("min");
     HashHeap maxheap = new HashHeap("max");
     for (int i = 0; i < nums.length; i++) {
         if (i != 0) {
             if (nums[i] > median) {
                 minheap.add(nums[i]);
             } else {
                 maxheap.add(nums[i]);
             }
         }

         if (i >= k) {
             if (median == nums[i - k]) {
                 if (maxheap.size() > 0) {
                     median = maxheap.poll();
                 } else if (minheap.size() > 0) {
                     median = minheap.poll();
                 } 

             } else if (median < nums[i - k]) {
                 minheap.delete(nums[i - k]);
             } else {
                 maxheap.delete(nums[i - k]);
             }
         }

         while (maxheap.size() > minheap.size()) {
             minheap.add(median);
             median = maxheap.poll();
         }
         while (minheap.size() > maxheap.size() + 1) {
             maxheap.add(median);
             median = minheap.poll();
         }

         if (i + 1 >= k) {
             ans.add(median);
         }
     }
     return ans;
 }
}
