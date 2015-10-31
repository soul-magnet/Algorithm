package DataStructure;

import java.util.HashMap;

/*
 * Analysis:
The key to solve this problem is using a double linked list which 
enables us to quickly move nodes.

LRU-Cache
The LRU cache is a hash table of keys and double linked nodes.
The hash table makes the time of get() to be O(1). 
The list of double linked nodes make the nodes adding/removal operations O(1).
 * 
 * */
public class LRUCache {
	// Define a double linked list node
	
	private class Node {
		int key;
		int value;
		Node pre;
		Node next;
		
		public Node (int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node tail = null;
	
	public LRUCache (int key){
		this.capacity = capacity;
	}
	
	public int get(int key){
		if (map.containsKey(key)){
			Node n= map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		
		return -1;
	}
	
	public void remove(Node n){
		if (n.pre != null){
			n.pre.next = n.next;
		}else{
			head = n.next;
		}
		
		if (n.next != null){
			n.next.pre = n.pre;
		} else {
			tail = n.pre;
		}
	}
	
	public void setHead(Node n){
		n.next = head;
		n.pre = null;
		
		if (head != null)
			head.pre = n;
		
		head = n;
		
		if (tail == null){
			tail = head;
		}
			
	}
	
	public void set(int key, int value){
		if (map.containsKey(key)){
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity){
				map.remove(tail.key);
				remove(tail);
				setHead(created);
			} else {
				setHead(created);
			}
			
			map.put(key, created);
		}
	}

}
