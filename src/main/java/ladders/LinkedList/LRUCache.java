package main.java.ladders.LinkedList;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 134. LRU Cache - Hard

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Example
Tags: Linked List Google Zenefits Uber
Related Problems 
Hard LFU Cache 18 %
 * */
public class LRUCache {
	private int capacity;
	private HashMap<Integer, Integer> hs = new HashMap<>();
	private Deque<Integer> deque = new LinkedList<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!hs.containsKey(key)) {return -1;}
		int temp = hs.get(key);
		deque.remove(key);
		deque.addLast(key);
		return temp;

	}

	public void set(int key, int value) {
		 if(get(key)!=-1){
            hs.put(key,value);
            return;
        }

		if (hs.size() == capacity) {
			hs.remove(deque.peekFirst());
			deque.removeFirst();

		}
		hs.put(key,value);
			deque.remove(key);
		deque.addLast(key);
		return;
	}

}
