package main.java.ladders.UnionFind;
/**
 * 591. Connecting Graph III 
 
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(), Returns the number of connected component in the graph

Example
5 // n = 5
query() return 5
connect(1, 2)
query() return 4
connect(2, 4)
query() return 3
connect(1, 4)
query() return 3
Tags 
Union Find
Related Problems 
Hard Minimum Spanning Tree 26 %
 * */

//Union Find
public class ConnectingGraph3 {
	
	private int[]id;
	private int size;
	
	public int find(int p) {
		while(p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}
	
	public int getComponent() {
		return size;
	}
	
	//initialize your data structure in here
	public ConnectingGraph3(int n) {
		size = n;
		for(int i =0 ; i< n+1; i++) {
			id[i] = i;
		}
	}
	
	public void connect(int a, int b) {
		// Write your code here
		int p1 = find(a);
		int p2 = find(b);
		
		while(p1 != p2) {
			p1 = id[p2];
			size--;
		}
	}
	
	public int query() {
		// Write your code here
		return getComponent();
	}
}
