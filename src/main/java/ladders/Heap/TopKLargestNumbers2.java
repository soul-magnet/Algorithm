package main.java.ladders.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 545. Top k Largest Numbers II - Medium - Optional

Implement a data structure, provide two interfaces:

add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.

Example
s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]

Tags: Heap Priority Queue
Related Problems 
Hard Top K Frequent Words II 19 %
Medium Top k Largest Numbers 35 %
Medium Top K Frequent Words 19 %
 * */
public class TopKLargestNumbers2 {
	int size;
	PriorityQueue<Integer> queue;

	public TopKLargestNumbers2(int k) {
		// initialize your data structure here.
		size = k;
		queue = new PriorityQueue<Integer>(size);

	}

	public void add(int num) {
		if (queue.size() == size) {
			if (queue.peek() < num) {
				queue.poll();
			} else {
				return;
			}
		}
		queue.offer(num);
	}

	public List<Integer> topk() {
	
		List<Integer> result = new ArrayList<Integer>();	
		Iterator it = queue.iterator();
		while (it.hasNext()) {
			result.add((Integer) it.next());
		}
		Collections.sort(result, Collections.reverseOrder());
		return result;
	}

}
