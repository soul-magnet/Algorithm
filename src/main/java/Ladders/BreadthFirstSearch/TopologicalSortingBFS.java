package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import GraphSearch.DirectedGraphNode;

/**
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 * Notice: You can assume that there is at least one topological order in the graph.
 * 
	...
	Challenge: Can you do it in both BFS and DFS?
 *
 * 
 * 
 * Thoughts:
 * BFS Approach
 * 1. Find the node which has no parent node: this will be the beginning node.
 *    Use a HashMap to map all nodes with children
 *    
 * 2. Starting from this node, put all nodes in the queue (breath-first)
 * 3. Process each node in the queue: add to array list
 * 
 * 
 *
 * */


/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class TopologicalSortingBFS {
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */  
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		
		if(graph == null || graph.size() == 0) return graph;
		
		//Keep track of all neighbors in HashMap
		HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
		for(DirectedGraphNode node : graph){
			for(DirectedGraphNode neighbor : node.neighbors){
				int keyN = neighbor.label;
				if(map.containsKey(keyN)){
					map.put(keyN, map.get(keyN) + 1);
				}else{
					map.put(keyN, 1);
				}
			}
		}
		
		//BFS: Add root node
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node : graph){
			if(!map.containsKey(node.label)){
				queue.offer(node);
				result.add(node);
			}
		}
		
		//BFS: go through all children
		while(!queue.isEmpty()){
			DirectedGraphNode node = queue.poll();
			for(DirectedGraphNode n : node.neighbors){
				int label = n.label;
				map.put(label, map.get(label) - 1);
				if(map.get(label) == 0){
					result.add(n);
					queue.offer(n);
				}
			}
		}
		
		return result;
	}
	
	

}
