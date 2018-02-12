package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 178. Graph Valid Tree - Medium

Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Notice: You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Tags: Depth First Search Facebook Zenefits Union Find Breadth First Search Google

Related Problems 
Medium Portal 26 %
Medium Connecting Graph 39 %
Medium Connected Component in Undirected Graph 25 %
 * */

public class GraphValidTree {
	 /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
     //BFS Approach - Its like course schedule - topological sort
	/*
	 * Thoughts: Typical BFS, 
	 * 1st generate adjacency list by adding edges to each other
	 * 2nd keep Queue and HashSet 
	 * 3rd traverse in the queue also traverse by the size of adjacencyList
	 * 4th if the edge has not been visited in adjacencyList add to the queue
	 * 5th return if the size of hashSet equal to the size of given n
	 * */
     	public boolean validTree1(int n, int[][] edges) {
     		if(n == 0 || !(edges.length == n-1)) return false;
     		
     		//generate the graph
     		ArrayList<Integer>[] adjacencyList = new ArrayList[n];
     		for(int i = 0; i < n; i++) {
     			adjacencyList[i] = new ArrayList<Integer>();
     		}
     		//undirected edges
     		for(int i = 0; i < edges.length; i++) {
     			adjacencyList[edges[i][0]].add(edges[i][1]);
     			adjacencyList[edges[i][1]].add(edges[i][0]);
     		}
     		
     		Queue<Integer>queue = new LinkedList<Integer>();
     		queue.add(0);
     		//no duplicate edges will appear in the edges
     		HashSet<Integer> hashSet = new HashSet<Integer>();
     		hashSet.add(0);
     		
     		while(!queue.isEmpty()) {
     			int size = queue.size();
     			for(int i = 0; i < size; i++) {
     				int node = queue.poll();
     				hashSet.add(node);
     				for(int j = 0; j < adjacencyList[node].size(); j++) {
     					if(!hashSet.contains(adjacencyList[node].get(j))) {
     						queue.offer(adjacencyList[node].get(j));
     					}
     				}
     			}
     		}
     		return hashSet.size() == n; //to be able to tree there shouldn't be cycle
     	}

}
